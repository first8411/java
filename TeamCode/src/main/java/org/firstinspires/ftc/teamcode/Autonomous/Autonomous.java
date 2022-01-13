/*
  ___ _ _  _ _ 
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/


package org.firstinspires.ftc.teamcode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.Autonomous_Base;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="final autonomous", group="finalized")

public class Autonomous extends LinearOpMode {

    Drive_Hardware robot = new Drive_Hardware();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // init
        robot.init(hardwareMap);
        telemetry.addData("Status", "start autonomous i coded thsi in like an hour please work first time i am begging you please pls pls pls thank u i hop so");
        waitForStart();
        

        // get the woah autonomous woah it works no way no way no way no way !
        moveForward();
        sleep(10);
        stopMovement();
    }
}