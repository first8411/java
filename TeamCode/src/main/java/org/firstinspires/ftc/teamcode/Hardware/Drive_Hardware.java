package org.firstinspires.ftc.teamcode.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Drive_Hardware {
    // public variables
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;

    // init hardware map
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    // public methods:
    public Drive_Hardware(){

    }

    public void init(HardwareMap ahwMap) {
        initClasses(ahwMap);
        motorInit();
        noPower();
        initEncoders();
    }

    public void waitForTick(long periodMs) {
        long remaining = periodMs - (long)period.milliseconds();

        if(remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        period.reset();
    }


    // Functions
    public void initClasses(HardwareMap ahwMap) {
        hwMap = ahwMap;
        leftFrontDrive = hwMap.dcMotor.get("LFD");
        leftBackDrive = hwMap.dcMotor.get("LBD");
        rightFrontDrive = hwMap.dcMotor.get("RFD");
        rightBackDrive = hwMap.dcMotor.get("RBD");
    }

    public void motorInit() {
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void noPower() {
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void initEncoders() {
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}