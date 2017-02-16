package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ThreadPool;

/**
 * Created by mcastleman18 on 2/9/17.
 */

@Autonomous
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


    double armSpeed = 0.25;
    double rightThreshold = 4.2;
    double centerThreshold = 4;
    double leftThreshold = 4.2;



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
    double startTime;

    @Override
    public void loop() {
        double centerValue = photoCenter.getVoltage();
        double leftValue = photoLeft.getVoltage();
        double rightValue = photoRight.getVoltage();
        if (state == 0) {
            // Drive forward until the line


            if (rightValue > rightThreshold || leftValue > leftThreshold) {
                //stop it
                stop();
                state++;
                startTime = getRuntime();
            } else {
                forward();

            }
        } else if (state == 1) {
            if (getRuntime() - startTime > 0.3) {
                stop();
                state++;
            } else {
                forward();
            }
        } else if(state == 2) {
            // Turn until in good position
            if (centerValue > centerThreshold) {
                stop();
                state++;
            } else {
                rotateRight();

            }

        }else if(state == 3) {

            if(rightValue > rightThreshold && leftValue > leftThreshold) {
                stop();
                state++;

            }else if (leftValue > leftThreshold) {

                turnLeft();

            }else if(rightValue > rightThreshold){
                turnRight();

            }else{
                forward();
            }


        }else{
            // Halt
            stop();
        }
        telemetry.addData("Photo Left: ",leftValue);
        telemetry.addData("Photo Center: ",centerValue);
        telemetry.addData("Photo Right: ",rightValue);

    }

    //Forward

    public void forward(){
        motorFrontLeft.setPower(0.1);
        motorFrontRight.setPower(-0.1);
        motorBackLeft.setPower(0.1);
        motorBackRight.setPower(-0.1);
    }

    //Turn left

    public void turnLeft(){
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(-0.25);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(-0.25);
    }
    //Turn right

    public void turnRight(){
        motorFrontLeft.setPower(0.25);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0.25);
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
        motorFrontLeft.setPower(0.18);
        motorFrontRight.setPower(0.18);
        motorBackLeft.setPower(0.18);
        motorBackRight.setPower(0.18);
    }


}
