package team.phantompanthers.opcodes.auto.impl;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import team.phantompanthers.RobotActions;
import team.phantompanthers.opcodes.auto.AutoOpCodeBase;

/**
 * <h1>AutoOpCode Documentation</h1>
 * The Actual TeleOp Code for the FTC Into the deep for the Phantom Panthers,
 */
@Autonomous(name = "IntoTheDeepAuto", group = "Linear Opmode")
public class AutoOpCode extends AutoOpCodeBase {

    @Override
    public void runOpMode() {
        initMotorSystem();
        // Will Run when Init Is Pressed
        waitForStart();
        while (opModeIsActive()) {
            RobotActions.drive(motorSystem, 0f, 1f, 3);
            RobotActions.stopMotion(motorSystem);
            RobotActions.drive(motorSystem, 0f, -0.4f, 2);
            RobotActions.stopMotion(motorSystem);
            RobotActions.driveTurnLeft(motorSystem, -0.4f, 2);
        }
    }
}
