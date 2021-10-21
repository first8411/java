package org.firstinspires.ftc.teamcode.Actual_Code.Hardware_New;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.qualcomm.robotcore.util.ElapsedTime;

public class driveHardware {

    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public driveHardware(){
        log.i("lol it got nothin");
    }

    public void init(HardwareMap ahwMap) {
        initClasses();
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

    public static void motorInit() {
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public static void noPower() {
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public static void initEncoders() {
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public static void initClasses() {
        hwMap = ahwMap;
        leftFrontDrive = hwMap.dcMotor.get("leftFrontDrive");
        leftBackDrive = hwMap.dcMotor.get("leftBackDrive");
        rightFrontDrive = hwMap.dcMotor.get("rightFrontDrive");
        rightBackDrive = hwMap.dcMotor.get("rightBackDrive");
    }
}