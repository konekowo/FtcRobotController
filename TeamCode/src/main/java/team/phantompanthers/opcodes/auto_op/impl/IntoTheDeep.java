package team.phantompanthers.opcodes.auto_op.impl;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import team.phantompanthers.Vector2f;
import team.phantompanthers.opcodes.auto_op.AutoOpCodeBase;

@Autonomous(name = "IntoTheDeep Autonomous", group = "Linear Opmode")
public class IntoTheDeep extends AutoOpCodeBase {

    @Override
    public void runOpMode() {
        super.runOpMode();
        // Will Run when Init Is Pressed
        waitForStart();
        sleep(robotActions.drive(new Vector2f(1f, 0f), 10));
        robotActions.stopMotion();
    }
}
