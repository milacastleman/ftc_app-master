package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by mcastleman18 on 1/30/17.
 */

@TeleOp
public class TeleOp1 extends OpMode {
    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;
    DcMotor motorArmLeft;
    DcMotor motorArmRight;


    double armSpeed = 1.0;

    @Override
    public void init() {

        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorArmLeft = hardwareMap.dcMotor.get("motorArmLeft");
        motorArmRight = hardwareMap.dcMotor.get("motorArmRight");
    }

    @Override
    public void loop() {
        float leftSpeed = -gamepad1.left_stick_y;
        float rightSpeed = gamepad1.right_stick_y;

        motorFrontLeft.setPower(leftSpeed);
        motorFrontRight.setPower(rightSpeed);
        motorBackLeft.setPower(leftSpeed);
        motorBackRight.setPower(rightSpeed);

        if(gamepad1.right_bumper) {

            motorArmRight.setPower(armSpeed);

        }else if(gamepad1.right_trigger > 0.3) {

            motorArmRight.setPower(-armSpeed);

        }else{
            motorArmRight.setPower(0);
        }

        if(gamepad1.left_bumper){

            motorArmLeft.setPower(-armSpeed);

        }else if(gamepad1.left_trigger > 0.3){

            motorArmLeft.setPower(armSpeed);

        }else{
            motorArmLeft.setPower(0);
        }




    }
}
