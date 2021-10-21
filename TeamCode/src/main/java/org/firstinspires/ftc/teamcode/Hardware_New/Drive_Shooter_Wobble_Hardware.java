/*
  ___ _ _  _ _ 
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/

package org.firstinspires.ftc.teamcode.Actual_Code.Hardware_New;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Drive_Shooter_Wobble_Hardware {
    // Public Operation Mode
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;

    public DcMotor intakeLeft = null;
    public DcMotor intakeRight = null;
    public DcMotor shooter = null;
    public Servo flicker = null;
    public DcMotor wobbleMotor = null;
    public CRServo wobbleExtensionServo = null;

    // Local

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public Drive_Shooter_Wobble_Hardware(){
        log.i("lol it got nothin");
    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        initializeMotors();
        reverseMotors();
        zeroPower();
        initEncoder();
    }

    public void waitForTick(long periodMs) {
        long remaining = periodMs - (long)period.milliseconds();

        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        period.reset();
        
    }

    // Functions

    public static void initializeMotors() {
        leftFrontDrive = hwMap.dcMotor.get("leftFrontDrive");
        leftBackDrive = hwMap.dcMotor.get("leftBackDrive");
        rightFrontDrive = hwMap.dcMotor.get("rightFrontDrive");
        rightBackDrive = hwMap.dcMotor.get("rightBackDrive");
        intakeLeft = hwMap.dcMotor.get("intakeLeft");
        intakeRight = hwMap.dcMotor.get("intakeRight");
        shooter = hwMap.dcMotor.get("shooter");
        flicker = hwMap.servo.get("flicker");
        wobbleMotor = hwMap.dcMotor.get("wobbleMotor");
        wobbleExtensionServo = hwMap.crservo.get("wobbleExtensionServo");
    }

    public static void reverseMotors() {
        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public static void zeroPower() {
        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
        intakeLeft.setPower(0);
        intakeRight.setPower(0);
        shooter.setPower(0);
        flicker.setPosition(0.0);
        wobbleMotor.setPower(0.0);
        wobbleExtensionServo.setPower(0.0);
    }

    public static void initEncoder() {
        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}