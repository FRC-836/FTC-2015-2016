package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by David Buddenbohn on 1/14/2016.
 */
public class TESTBLUE extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorIsmail;

    @Override
    public void runOpMode() throws InterruptedException {
        motorRight = hardwareMap.dcMotor.get("motor_2"); //motor 2 is right motor
        motorLeft = hardwareMap.dcMotor.get("motor_1");

        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(0);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(0);
        motorLeft.setPower(0);
        sleep(1000);
        motorRight.setPower(0);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);


        motorRight.setPowerFloat();
        motorLeft.setPowerFloat();
    }
}