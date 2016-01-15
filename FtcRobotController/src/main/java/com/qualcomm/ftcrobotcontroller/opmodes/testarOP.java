package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by David Buddenbohn on 11/23/2015.
 * Not uploaded to Git.
 * For testing purposes.
 * You can delete.
*/

import com.qualcomm.ftccommon.FtcWifiChannelSelectorActivity;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class testarOP extends OpMode {

    Servo servonuke;
    DcMotor motormobydick;
    DcMotor motorKnight;
    DcMotor motorRobodaddy;
    DcMotor motorRight;
    DcMotor motorLeft;

    /**
     * Constructor
     */
    public testarOP() {

    }

    /*
     * Code to run when the op mode is first enabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
    @Override
    public void init() {
		/*
		 * Use the hardwareMap to get the dc motors and servos by name. Note
		 * that the names of the devices must match the names used when you
		 * configured your robot and created the configuration file.
		 */

		/*
		 * For the demo Tetrix K9 bot we assume the following,
		 *   There are two motors "motor_1" and "motor_2"
		 *   "motor_1" is on the right side of the bot.
		 *   "motor_2" is on the left side of the bot.
		 */
        servonuke = hardwareMap.servo.get("nuke");
        motormobydick = hardwareMap.dcMotor.get("mobydick");
        motorKnight = hardwareMap.dcMotor.get("knightsrule");
        motorRobodaddy = hardwareMap.dcMotor.get("robodaddy69");
        motorRight = hardwareMap.dcMotor.get("motor_2"); //motor 2 is right motor
        motorLeft = hardwareMap.dcMotor.get("motor_1");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

    }

    /*
     * This method will be called repeatedly in a loop
     *the robodaddy and mobydick have been made by ultron
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#run()
     */
    @Override
    public void loop() {

		/*
		 * Gamepad 1
		 *
		 * Gamepad 1 controls the motors via the left stick, and it controls the
		 * wrist/claw via the a,b, x, y buttons
		 */

        // tank drive
        // note that if y equal -1 then joystick is pushed all of the way forward.
        float nuke;
        float mobydick;
        float knight;
        float robodaddy;

        if (gamepad1.dpad_up) {
            mobydick = 1;
        } else if(gamepad1.dpad_down) {
            mobydick = -1;
        } else {
            mobydick = 0;
        }

        if (gamepad1.y) {
            nuke = 180;
        } else if(gamepad1.a) {
            nuke = 0;
        } else {
            nuke = 0;
        }

        if (gamepad1.right_bumper) {
            knight = 1;
        } else if(0 < gamepad1.right_trigger) {
            knight = -1;
        } else {
            knight = 0;
        }


        if (gamepad1.left_bumper) {
           robodaddy = 1;
        } else if(0 < gamepad1.left_trigger) {
            robodaddy = -1;
        } else {
            robodaddy= 0;
        }

        float left = -gamepad1.left_stick_y;
        float right = -gamepad1.right_stick_y;

        // clip the right/left values so that the values never exceed +/- 1
        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        // scale the joystick value to make it easier to control
        // the robot more precisely at slower speeds.
        right = (float)scaleInput(right);
        left =  (float)scaleInput(left);

        // write the values to the motors
        servonuke.setPosition(nuke);
        motormobydick.setPower(mobydick);
        motorKnight.setPower(knight);
        motorRobodaddy.setPower(robodaddy);
        motorRight.setPower(right);
        motorLeft.setPower(left);

        // clip the position values so that they never exceed their allowed range.
        // armPosition = Range.clip(armPosition, ARM_MIN_RANGE, ARM_MAX_RANGE);
        // clawPosition = Range.clip(clawPosition, CLAW_MIN_RANGE, CLAW_MAX_RANGE);

        // write position values to the wrist and claw servo
        // arm.setPosition(armPosition);
        // claw.setPosition(clawPosition);

		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */

        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("left tgt pwr",  "left  pwr: " + String.format("%.2f", left));
        telemetry.addData("right tgt pwr", "right pwr: " + String.format("%.2f", right));
    }

    /*
     * Code to run when the op mode is first disabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
     */
    @Override
    public void stop() {

    }

    /*
     * This method scales the joystick input so for low joystick values, the
     * scaled value is less than linear.  This is to make it easier to drive
     * the robot more precisely at slower speeds.
     */
    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}
