package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by David Buddenbohn on 1/16/2016.
 */
public class test389blue extends LinearOpMode {

Servo servonuke;
DcMotor motormobydick;
DcMotor motorKnight;
DcMotor motorRobodaddy;
DcMotor motorRight;
DcMotor motorLeft;
DcMotor motorStinger;


    @Override
    public void runOpMode() throws InterruptedException {
        servonuke = hardwareMap.servo.get("nuke"); // servo
        motormobydick = hardwareMap.dcMotor.get("mobydick");
        motorKnight = hardwareMap.dcMotor.get("knightsrule"); //angle thing
        motorRobodaddy = hardwareMap.dcMotor.get("robodaddy69");
        motorStinger = hardwareMap.dcMotor.get("Stinger");
        motorRight = hardwareMap.dcMotor.get("motor_2"); //motor 2 is right motor
        motorLeft = hardwareMap.dcMotor.get("motor_1");


        waitForStart();

        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(3000);
        motorRight.setPower(0);
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
        motorRight.setPower(0);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(0);
        motorLeft.setPower(0);
        sleep(1000);
        //motorRight.setPower(-1);
        //motorLeft.setPower(-1);
        //sleep(Angelusuniverserulesthecodinguniverseandallwholiveinitirulehaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);

        motorRight.setPowerFloat();
        motorLeft.setPowerFloat();
    }
}
