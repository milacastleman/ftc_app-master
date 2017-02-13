package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ThreadPool;

/**
 * Created by mcastleman18 on 2/9/17.
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


    double armSpeed = 1.0;
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
        }else if(state == 1){
            // Turn until we in good position
            turnRight();

        }else if(state == 2) {
            //Follow the line until the center sensor goes black

        }else{
            // Halt
        }

    }

    //Forward

    public void forward(){
        motorFrontLeft.setPower(1);
        motorFrontRight.setPower(-1);
        motorBackLeft.setPower(1);
        motorBackRight.setPower(-1);
    }

    //Turn left

    public void turnLeft(){
        motorFrontLeft.setPower(1);
        motorFrontRight.setPower(1);
        motorBackLeft.setPower(1);
        motorBackRight.setPower(1);
    }
    //Turn right

    public void turnRight(){
        motorFrontLeft.setPower(-1);
        motorFrontRight.setPower(-1);
        motorBackLeft.setPower(-1);
        motorBackRight.setPower(-1);
    }

    //Stop

    public void stop(){
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);

    }


}
