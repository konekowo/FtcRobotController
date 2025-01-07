package team.phantompanthers.opcodes.auto_op;

import team.phantompanthers.RobotActions;
import team.phantompanthers.opcodes.OpCodeBase;

public abstract class AutoOpCodeBase extends OpCodeBase {
    protected RobotActions robotActions;

    @Override
    public void runOpMode() {
        super.runOpMode();
        this.robotActions = new AutoOpRobotActions(this.motorSystem, this.servoSystem);
    }
}

