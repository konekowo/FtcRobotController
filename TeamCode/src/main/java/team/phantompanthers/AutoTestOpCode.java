package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * <h1>AutoTestOpCode Documentation</h1>
 * A Autonomous OpMode for controlling a robot during the Driver Controlled period.
 * this class extends LinearOpMode and implements Movement for more functionality.
 */
@Autonomous
public abstract class AutoTestOpCode extends LinearOpMode {
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
            RobotActions.driveForward(motorSystem, 1.0, 2000);
            sleep(1000);
            RobotActions.driveBackward(motorSystem, 1.0, 2000);
        }
    }
}

