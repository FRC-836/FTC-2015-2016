package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/*
 * An example linear op mode where the pushbot
 * will drive in a square pattern using sleep()
 * and a for loop.
 */
public class testIsmail extends LinearOpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorIsmail;

    @Override
    public void runOpMode() throws InterruptedException {
        motorRight = hardwareMap.dcMotor.get("motor_2"); //motor 2 is right motor
        motorLeft = hardwareMap.dcMotor.get("motor_1");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(0);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(0);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        motorRight.setPower(1);
        motorLeft.setPower(1);
        sleep(1000);
        //motorRight.setPower(-1);
        //motorLeft.setPower(-1);
        //sleep(Angelusuniverserulesthecodinguniverseandallwholiveinitirulehaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa);

        motorRight.setPowerFloat();
        motorLeft.setPowerFloat();
    }
}

