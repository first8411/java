/*
  ___ _ _  _ _ 
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/

package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.Drive_Hardware;

@Autonomous(name="Autonomous_Base", group="Testing")
@Disabled

public class Autonomous_Base extends LinearOpMode {
    // create HW map
    Drive_Hardware robot = new Drive_Hardware();
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        // Initialize the program
        robot.init(hardwareMap);
//        log.i("🚀 Ready to launch!");
        waitForStart();

        // autonomous
        moveForward();
        stopMovement();
//        log.i("✅ WOOOOOOOO!");

        // Done!
    }


    // autonomous drive functions:

    // drive
    public void drive(double left, double right) {
        robot.leftFrontDrive.setPower(left);
        robot.rightFrontDrive.setPower(right);
        robot.leftBackDrive.setPower(left);
        robot.rightBackDrive.setPower(right);
    }

    // stop
    public void stopMovement() {
        robot.leftFrontDrive.setPower(0);
        robot.rightFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        sleep(100);
    }

    // forward
    public void moveForward() {
        robot.leftFrontDrive.setPower(-1);
        robot.rightFrontDrive.setPower(-1);
        robot.leftBackDrive.setPower(-1);
        robot.rightBackDrive.setPower(-1);
        sleep(100);
    }

    // backwards
    public void moveBackwards() {
        robot.leftFrontDrive.setPower(1);
        robot.rightFrontDrive.setPower(1);
        robot.leftBackDrive.setPower(1);
        robot.rightBackDrive.setPower(1);
        sleep(100);
    }

    // left
    public void moveLeft() {
        robot.leftFrontDrive.setPower(1);
        robot.rightFrontDrive.setPower(-1);
        robot.leftBackDrive.setPower(1);
        robot.rightBackDrive.setPower(-1);
        sleep(100);
    }

    // right
    public void moveRight() {
        robot.leftFrontDrive.setPower(-1);
        robot.rightFrontDrive.setPower(1);
        robot.leftBackDrive.setPower(-1);
        robot.rightBackDrive.setPower(1);
        sleep(100);
    }
}