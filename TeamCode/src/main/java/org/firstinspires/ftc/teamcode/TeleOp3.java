package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by mcastleman18 on 11/4/17.
 */

@TeleOp
public class TeleOp3 extends OpMode {
    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    Servo servoArmLeft;


    double armSpeed = 1.0;

    @Override
    public void init() {

        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        servoArmLeft = hardwareMap.servo.get("servoArmLeft");
    }

    @Override
    public void loop() {
        float leftSpeed = -gamepad1.left_stick_y;
        float rightSpeed = gamepad1.right_stick_y;

        motorFrontLeft.setPower(leftSpeed);
        motorFrontRight.setPower(rightSpeed);
    }}