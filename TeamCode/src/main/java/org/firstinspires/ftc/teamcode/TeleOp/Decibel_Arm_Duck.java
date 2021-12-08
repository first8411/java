/*
  ___ _ _  _ _
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/

package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Decibel_Arm_Duck", group="Decibel")
//@Disabled
public class Decibel_Arm_Duck extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor LFD = null;
    private DcMotor LBD = null;
    private DcMotor RFD = null;
    private DcMotor RBD = null;

    private DcMotor Arm = null;
    private DcMotor Intake = null;

    private DcMotor Duck = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        LFD  = hardwareMap.get(DcMotor.class, "LFD");
        LBD = hardwareMap.get(DcMotor.class, "LBD");
        RFD  = hardwareMap.get(DcMotor.class, "RFD");
        RBD = hardwareMap.get(DcMotor.class, "RBD");

        Arm = hardwareMap.get(DcMotor.class, "Arm");
        Intake = hardwareMap.get(DcMotor.class, "Intake");

        Duck = hardwareMap.get(DcMotor.class, "Duck");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        LFD.setDirection(DcMotor.Direction.FORWARD);
        LBD.setDirection(DcMotor.Direction.FORWARD);
        RFD.setDirection(DcMotor.Direction.REVERSE);
        RBD.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;
            double driveSpeed = 0.5;

            double ArmPower;
            double IntakePower = 0;

            double DuckPower = 0;

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            if (gamepad1.dpad_up) {
                ArmPower = 1;
            } else if (gamepad1.dpad_down) {
                ArmPower = -1;
            } else {
                ArmPower = 0;
            }

            if (IntakePower > 0 || IntakePower < 0) {
                if (gamepad1.x || gamepad1.y) {
                    IntakePower = 0;
                }
            } else {
                if (gamepad1.x) {
                    IntakePower = 0.5;
                } else if (gamepad1.y) {
                    IntakePower = -0.5;
                }
            }


            if (gamepad1.dpad_left) {
                DuckPower = 1;
            } else if (gamepad1.dpad_right) {
                DuckPower = -1;
            } else {
                DuckPower = 0;
            }


            // Send calculated power to wheels
            LFD.setPower(leftPower * driveSpeed);
            LBD.setPower(leftPower * driveSpeed);
            RFD.setPower(rightPower * driveSpeed);
            RBD.setPower(rightPower * driveSpeed);

            Arm.setPower(ArmPower);
            Intake.setPower(IntakePower);

            Duck.setPower(DuckPower);


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
