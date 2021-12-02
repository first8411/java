/*
  ___ _ _  _ _
 ( _ ) | |/ / |
 / _ \_  _| | |
 \___/ |_||_|_|

*/

package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Carousel {
    private DcMotor carouselMotor;

    public void init(HardwareMap hwMap) {
        carouselMotor = hardwareMap.get(DcMotor.class, "carouselMotor");
        carouselMotor.setPower(0);
    }

    public void rotate(boolean button, boolean button2) {
        if(button) {
            carouselMotor.setPower(-.5);
        } else if (button2) {
            carouselMotor.setPower(0.5);
        } else {
            carouselMotor.setPower(0);
        }
    }

    public DcMotor getCarouselMotor() {
        return carouselMotor;
    }
}