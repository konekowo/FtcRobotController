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
        robotActions.drive(0, -1f);
        sleep(250L);
        robotActions.stopMotion();
        sleep(500L);
        robotActions.drive(1f, 0f);
        sleep(500L);
        robotActions.stopMotion();
    }
}
