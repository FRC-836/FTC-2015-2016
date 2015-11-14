package org.robobees.control;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Jim on 11/12/2015.
 */

public class Arm
{
    /*
     * Note: the configuration of the servos is such that
     * as the arm servo approaches 0, the arm position moves up (away from the floor).
     * Also, as the claw servo approaches 0, the claw opens up (drops the game element).
     */
    // TETRIX VALUES.
    final static double ARM_MIN_RANGE  = 0.20;
    final static double ARM_MAX_RANGE  = 0.90;
    final static double CLAW_MIN_RANGE  = 0.20;
    final static double CLAW_MAX_RANGE  = 0.7;

    // position of the arm servo.
    double armPosition;

    // amount to change the arm servo position.
    double armDelta = 0.1;

    // position of the claw servo
    double clawPosition;

    // amount to change the claw servo position by
    double clawDelta = 0.1;

    Servo claw;
    Servo arm;

    HardwareMap hardwareMap;
    Gamepad gamepad;
    Telemetry telemetry;


    public Arm(HardwareMap inHardwareMap, Gamepad inGamePad, Telemetry inTelemetry) {
        HardwareMap hardwareMap = inHardwareMap;
        gamepad = inGamePad;
        Telemetry telemetry = inTelemetry;
    }


    public void init()
    {
        arm = hardwareMap.servo.get("servo_1");
        claw = hardwareMap.servo.get("servo_6");

        // assign the starting position of the wrist and claw
        armPosition = 0.2;
        clawPosition = 0.2;
    }

    public void loop(boolean enableTelemetry)
    {		// update the position of the arm.
        if (gamepad.a) {
            // if the A button is pushed on gamepad1, increment the position of
            // the arm servo.
            armPosition += armDelta;
        }

        if (gamepad.y) {
            // if the Y button is pushed on gamepad1, decrease the position of
            // the arm servo.
            armPosition -= armDelta;
        }

        // update the position of the claw
        if (gamepad.x) {
            clawPosition += clawDelta;
        }

        if (gamepad.b) {
            clawPosition -= clawDelta;
        }

        // clip the position values so that they never exceed their allowed range.
        armPosition = Range.clip(armPosition, ARM_MIN_RANGE, ARM_MAX_RANGE);
        clawPosition = Range.clip(clawPosition, CLAW_MIN_RANGE, CLAW_MAX_RANGE);

        // write position values to the wrist and claw servo
        arm.setPosition(armPosition);
        claw.setPosition(clawPosition);

        if (enableTelemetry) {
            telemetry.addData("arm", "arm:  " + String.format("%.2f", armPosition));
            telemetry.addData("claw", "claw:  " + String.format("%.2f", clawPosition));
        }

    }

    public void stop() {

    }
}
