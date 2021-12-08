package org.firstinspires.ftc.teamcode.Autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.Drive_Hardware;
import org.firstinspires.ftc.teamcode.Util.Random;

@Autonomous(name="Disco", group="Bruh")
//@Disabled


public class Disco extends LinearOpMode {

    // create HW map
    Drive_Hardware robot = new Drive_Hardware();
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        // Initialize the program
        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready to launch...");
        waitForStart();

        sleep((int)Math.floor(Math.random()*2000));

        for (int i = 0; i < 10; i++) {
            int randomNumber = (int)Math.floor(Math.random()*10);

            switch (randomNumber) {
                case 1:  moveForward();
                    break;
                case 2:  moveBackwards();
                    break;
                case 3:  moveLeft();
                    break;
                case 4:  moveRight();
                    break;
                case 5:  moveForward();
                    break;
                case 6:  moveBackwards();
                    break;
                case 7:  moveLeft();
                    break;
                case 8:  moveRight();
                    break;
                case 9:  stopMovement();
                    break;
                case 10: stopMovement();
                    break;
            }

            sleep(500);
            stopMovement();
            sleep(500);
        }

        telemetry.addData("Status", "Completed autonomous!");
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
