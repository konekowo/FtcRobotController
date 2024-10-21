package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * <h1>AutoTestOpCode Documentation</h1>
 * A Autonomous OpMode for controlling a robot during the Driver Controlled period.
 * this class extends LinearOpMode and implements Movement for more functionality.
 */
@Autonomous
public class AutoTestOpCode extends LinearOpMode implements Movement {

    DcMotor leftMotor;
    DcMotor rightMotor;

    // Constructor for Class
    public AutoTestOpCode(DcMotor leftMotor,DcMotor rightMotor){
        runOpMode();
    }

    public void runOpMode() {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        // Will Run when Init Is Pressed
        waitForStart();
        if (opModeIsActive()) {
            driveForward(1.0,2000);

            stopMotion();
            sleep(1000);

            driveBackward(1.0,2000);
            stopMotion();
        }
    }


    // Auto Movement Functions

    /**
     * FTC Robot Motion
     * @param power is the speed the Robot Will Go.
     * @param time is how long it will last until next Method.
     */
    public void driveForward(double power, long time) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
        sleep(time);
    }

    /**
     * FTC ROBOT MOTION
     * @param power is the speed and direction the Robot Will Go (-power) means BackWards.
     * @param time is how long it will last until next Method
     */
    public void driveBackward(double power, long time) {
      leftMotor.setPower(-power);
      rightMotor.setPower(-power);
      // Stops moving after time
      sleep(time);
    }


    /**
     * Completely Makes The Robot Stationary setting power to 0.
     */
    public void stopMotion() {
      leftMotor.setPower(0);
      rightMotor.setPower(0);
    }
}

