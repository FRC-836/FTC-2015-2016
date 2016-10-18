package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


public class MentorBotOP extends OpMode
{
  //enums
  private enum DriveMode
  {
    Tank,
    Arcade
  };

  //hardware
  private DcMotor leftMotor;
  private DcMotor rightMotor;

  //variables
  DriveMode currentDriveMode;

  @Override
  public void init()
  {
    leftMotor = hardwareMap.dcMotor.get("leftMotor");
    leftMotor.setDirection(DcMotor.Direction.REVERSE); //reverse backwards motor
    rightMotor = hardwareMap.dcMotor.get("rightMotor");
    //rightMotor.setDirection(DcMotor.Direction.REVERSE);
    currentDriveMode = DriveMode.Tank;
  }
  @Override
  public void loop()
  {
    //drive speeds
    double throttle = 0.0;
    double steer = 0.0;
    double leftWheel = 0;
    double rightWheel = 0;

    //determine drivemode
    if (gamepad1.dpad_up)
    {
      currentDriveMode = DriveMode.Tank;
      leftMotor.setDirection(DcMotor.Direction.REVERSE);
      rightMotor.setDirection(DcMotor.Direction.FORWARD);
    }
    else if (gamepad1.dpad_down)
    {
      currentDriveMode = DriveMode.Arcade;
      leftMotor.setDirection(DcMotor.Direction.FORWARD);
      rightMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    //generate wheel values based on drive mode
    switch(currentDriveMode)
    {
      case Arcade:
        throttle = Range.clip(gamepad1.left_stick_y, -1, 1);
        steer = Range.clip(gamepad1.right_stick_x, -1, 1);
        steer *= -1;
        leftWheel = Range.clip(steer - throttle, -1, 1);
        rightWheel = Range.clip(throttle + steer, -1, 1);
        break;
      case Tank:
        rightWheel = Range.clip(gamepad1.left_stick_y, -1, 1);
        leftWheel = Range.clip(gamepad1.right_stick_y, -1, 1);
        break;
    }

    //write wheel values
    rightMotor.setPower(rightWheel);
    leftMotor.setPower(leftWheel);
  }
}
