package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by mcastleman18 on 10/28/17.
 */

@TeleOp
public class TeleOp2 extends OpMode {
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

            if (gamepad1.left_bumper) {
                // move to 0 degrees.
                servoArmLeft.setPosition(0);
            } else if (gamepad1.right_bumper ) {
                // move to 90 degrees.
                servoArmLeft.setPosition(1);
            }
        else{
                servoArmLeft.setPosition(0.5);
            }
            telemetry.addData("Servo Position", servoArmLeft.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();


    }
}