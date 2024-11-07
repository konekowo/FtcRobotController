package team.phantompanthers.opcodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import team.phantompanthers.RobotActions;

/**
 * <h1>AutoTestOpCode Documentation</h1>
 * A Autonomous OpMode for controlling a robot during the Driver Controlled period.
 * this class extends LinearOpMode and implements Movement for more functionality.
 */
@Autonomous
public abstract class AutoOpCodeBase extends OpCodeBase {
    public void runOpMode() {
        initMotorSystem();
        // Will Run when Init Is Pressed
        waitForStart();
        if (opModeIsActive()) {
            RobotActions.driveForward(motorSystem, 1.0, 2000);
            sleep(1000);
            RobotActions.driveBackward(motorSystem, 1.0, 2000);
        }
    }
}

