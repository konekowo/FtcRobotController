package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * <h1>AutoTestOpCode Documentation</h1>
 * A Autonomous OpMode for controlling a robot during the Driver Controlled period.
 * this class extends LinearOpMode and implements Movement for more functionality.
 */
@Autonomous
public abstract class AutoTestOpCode extends LinearOpMode implements Movement {
    protected MotorSystem motorSystem;

    /**
     * Initiates the motor system for use.
     * Please call this method in runOpMode()!!
     */
    protected void initMotorSystem() {
        motorSystem = new MotorSystem(hardwareMap, telemetry);
    }

    public void runOpMode() {
        initMotorSystem();
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");

        // Will Run when Init Is Pressed
        waitForStart();
        if (opModeIsActive()) {
            driveForward(1.0, 2000);

            stopMotion();
            sleep(1000);

            driveBackward(1.0, 2000);
            stopMotion();
        }
    }


    // Auto Movement Functions

    /**
     * FTC Robot Motion
     *
     * @param power is the speed the Robot Will Go.
     * @param time  is how long it will last until next Method.
     */
    public void driveForward(double power, long time) {
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        // Stops moving after time
        sleep(time);
    }

    /**
     * FTC ROBOT MOTION
     *
     * @param power is the speed and direction the Robot Will Go (-power) means BackWards.
     * @param time  is how long it will last until next Method
     */
    public void driveBackward(double power, long time) {
        motorSystem.setPower("top_left_motor", -power);
        motorSystem.setPower("top_right_motor", -power);
        motorSystem.setPower("bottom_left_motor", -power);
        motorSystem.setPower("bottom_right_motor", -power);
        // Stops moving after time
        sleep(time);
    }


    /**
     * Completely Makes The Robot Stationary setting power to 0.
     */
    public void stopMotion() {
        motorSystem.setPower("top_left_motor", 0);
        motorSystem.setPower("top_right_motor", 0);
        motorSystem.setPower("bottom_left_motor", 0);
        motorSystem.setPower("bottom_right_motor", 0);
    }
}

