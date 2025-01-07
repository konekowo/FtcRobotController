package team.phantompanthers.opcodes.tele_op;

import team.phantompanthers.RobotActions;
import team.phantompanthers.opcodes.OpCodeBase;

public abstract class TeleOpCodeBase extends OpCodeBase {
    protected RobotActions robotActions;

    @Override
    public void runOpMode() {
        super.runOpMode();
        robotActions = new TeleOpRobotActions(this.motorSystem, this.servoSystem);
    }
}
