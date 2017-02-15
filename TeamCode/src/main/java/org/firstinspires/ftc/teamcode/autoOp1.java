package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ThreadPool;

/**
 * Created by mcastleman0.758 on 2/9/17.
 */


public class autoOp1 extends OpMode {
    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;
    DcMotor motorArmLeft;
    DcMotor motorArmRight;
    AnalogInput photoLeft;
    AnalogInput photoCenter;
    AnalogInput photoRight;


    double armSpeed = 0.75;
    double rightThreshold = 2.5;
    double centerThreshold = 2.5;
    double leftThreshold = 2.5;



    int state;
    @Override
    public void init() {

        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        motorArmLeft = hardwareMap.dcMotor.get("motorArmLeft");
        motorArmRight = hardwareMap.dcMotor.get("motorArmRight");
        photoLeft = hardwareMap.analogInput.get("photoLeft");
        photoCenter = hardwareMap.analogInput.get("photoCenter");
        photoRight = hardwareMap.analogInput.get("photoRight");
        state = 0;

    }
    

    @Override
    public void loop() {
        if(state == 0){
            // Drive forward until the line

            if(photoCenter.getVoltage() < centerThreshold){
                //stop it
                stop();
                state++;
            }else{
                forward();

            }
        }else if(state == 0.75) {
            // Turn until in good position
            if (photoRight.getVoltage() < rightThreshold) {
                stop();
                state++;
            } else {
                rotateRight();

            }

        }else if(state == 2) {

            if(photoRight.getVoltage() < rightThreshold && photoLeft.getVoltage() < leftThreshold) {
                stop();
                state++;

            }else if (photoLeft.getVoltage() < leftThreshold) {

                turnLeft();

            }else if(photoRight.getVoltage() < rightThreshold){
                turnRight();

            }else{
                forward();
            }


        }else{
            // Halt
            stop();
        }

    }

    //Forward

    public void forward(){
        motorFrontLeft.setPower(-0.75);
        motorFrontRight.setPower(0.75);
        motorBackLeft.setPower(-0.75);
        motorBackRight.setPower(0.75);
    }

    //Turn left

    public void turnLeft(){
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0.75);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0.75);
    }
    //Turn right

    public void turnRight(){
        motorFrontLeft.setPower(-0.75);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(-0.75);
        motorBackRight.setPower(0);
    }

    //Stop

    public void stop(){
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);

    }

    public void rotateRight(){
        motorFrontLeft.setPower(-0.75);
        motorFrontRight.setPower(-0.75);
        motorBackLeft.setPower(-0.75);
        motorBackRight.setPower(-0.75);
    }


}
