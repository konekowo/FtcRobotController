package team.phantompanthers.opcodes.auto_op.impl;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import team.phantompanthers.opcodes.auto_op.AutoOpCodeBase;

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
