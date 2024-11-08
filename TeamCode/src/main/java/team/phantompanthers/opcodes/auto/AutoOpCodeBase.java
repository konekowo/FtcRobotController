package team.phantompanthers.opcodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import team.phantompanthers.RobotActions;
import team.phantompanthers.opcodes.OpCodeBase;

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
            RobotActions.drive(motorSystem, 0, 1f, 2000);
            RobotActions.stopMotion(motorSystem);
            sleep(1000);
            RobotActions.drive(motorSystem, 0, -1f, 2000);
            RobotActions.stopMotion(motorSystem);
        }
    }
}

