package team.phantompanthers.opcodes.tele_op;

import team.phantompanthers.opcodes.OpCodeBase;

public abstract class TeleOpCodeBase extends OpCodeBase {
    protected TeleOpRobotActions robotActions;

    @Override
    public void runOpMode() {
        super.runOpMode();
        robotActions = new TeleOpRobotActions(this.motorSystem, this.servoSystem);
    }
}
