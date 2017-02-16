package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;

/**
 * Created by mcastleman18 on 2/16/17.
 */
@Autonomous
public class printSensorOp extends OpMode {
    AnalogInput photoLeft;
    AnalogInput photoCenter;
    AnalogInput photoRight;
    @Override
    public void init() {
        photoLeft = hardwareMap.analogInput.get("photoLeft");
        photoCenter = hardwareMap.analogInput.get("photoCenter");
        photoRight = hardwareMap.analogInput.get("photoRight");
    }

    @Override
    public void loop() {
        telemetry.addData("Photo Left:",photoLeft.getVoltage());
        telemetry.addData("Photo Center:",photoCenter.getVoltage());
        telemetry.addData("Photo Right:",photoRight.getVoltage());
    }
}

