package team.phantompanthers.opcodes.auto_op.impl;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import team.phantompanthers.opcodes.auto_op.AutoOpCodeBase;

/**
 * <h1>AutoOpCode Documentation</h1>
 * The Actual TeleOp Code for the FTC Into the deep for the Phantom Panthers,
 */
@Autonomous(name = "IntoTheDeep Autonomous", group = "Linear Opmode")
public class IntoTheDeep extends AutoOpCodeBase {

    @Override
    public void runOpMode() {
        super.runOpMode();
        // Will Run when Init Is Pressed
        waitForStart();

        robotActions.drive(0f, 1f);
        robotActions.sleep(500L);
        robotActions.stopMotion();
    }
}
