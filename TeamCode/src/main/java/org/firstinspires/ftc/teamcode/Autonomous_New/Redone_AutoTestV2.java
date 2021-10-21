/*
  ___ _ _  _ _ 
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/

package org.firstinspires.ftc.Actual_Code.Autonomous_New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.firstinspires.ftc.Actual_Code.Hardware.Drive_Shooter_Wobble_Hardware;

@Autonomous(Name="Redone_AutoTestV2", group="Testing")
@Disabled

public class Autotest1 extends LinearOpMode {

    Drive_Shooter_Wobble_Hardware robot = new Drive_Shooter_Wobble_Hardware();
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOperationMode() {

        // Initialize the program
        robot.init(hardwareMap);
        log.i("🚀 Ready to launch!");
        waitForStart();

        // autonomous
        moveForward();
        stopMovement();
        log.i("✅ WOOOOOOOO!");

        // Done!
    }

    public void drive(double left, double right) {
        robot.leftFrontDrive.setPower(left);
        robot.rightFrontDrive.setPower(right);
        robot.leftBackDrive.setPower(left);
        robot.rightBackDrive.setPower(right);
    }

    // Recoded the old autonomous with functions 

        /* Forward */

        public static void moveForward() {
            robot.leftFrontDrive.setPower(-1);
            robot.rightFrontDrive.setPower(-1);
            robot.leftBackDrive.setPower(-1);
            robot.rightBackDrive.setPower(-1);
            sleep(100);
        }

        /* Stopping Movement */
        
        public static void stopMovement() {
            robot.leftPowerDrive.setPower(0);
            robot.rightFrontDrive.setPower(0);
            robot.leftBackDrive.setPower(0);
            robot.rightBackDrive.setPower(0);
            sleep(100);
        }

        /* Right */

        public static void moveRight() {
            robot.leftFrontDrive.setPower(-1);
            robot.rightFrontDrive.setPower(1);
            robot.leftBackDrive.setPower(-1);
            robot.rightBackDrive.setPower(1);
            sleep(100);
        }

        /* Left */

        public static void moveLeft() {
            robot.leftFrontDrive.setPower(1);
            robot.rightFrontDrive.setPower(-1);
            robot.leftBackDrive.setPower(1);
            robot.rightBackDrive.setPower(-1);
            sleep(100);
        }
        

        /* Backwards */

        public static void moveBackwards() {
            robot.leftFrontDrive.setPower(1);
            robot.rightFrontDrive.setPower(1);
            robot.leftBackDrive.setPower(1);
            robot.rightBackDrive.setPower(1);
            sleep(100);
        }
}