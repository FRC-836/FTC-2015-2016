package org.robobees.opmodes;

/**
 * Created by Jim on 11/13/2015.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.robobees.control.Arm;
import org.robobees.control.TankDrive;

/**
 * Linear Tele Op Mode
 * <p>
 * Enables control of the robot via the gamepad.
 * NOTE: This op mode will not work with the NXT Motor Controllers. Use an Nxt op mode instead.
 */
public class LinearOp_1 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        TankDrive drive = new TankDrive(hardwareMap, gamepad1, telemetry);
        Arm armControl = new Arm(hardwareMap, gamepad1, telemetry);

        waitForStart();

        while (opModeIsActive()) {



            waitOneFullHardwareCycle();
        }
    }
}
