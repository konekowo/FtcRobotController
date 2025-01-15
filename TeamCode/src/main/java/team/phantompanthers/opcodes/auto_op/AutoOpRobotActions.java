package team.phantompanthers.opcodes.auto_op;

import team.phantompanthers.RobotActions;
import team.phantompanthers.part_specific.ClawState;
import team.phantompanthers.part_specific.MotorSystem;
import team.phantompanthers.part_specific.ServoSystem;

public class AutoOpRobotActions extends RobotActions {

    public AutoOpRobotActions(MotorSystem motorSystem, ServoSystem servoSystem) {
        super(motorSystem, servoSystem);
    }

    public void drive(double powerX, double powerY) {
        super.drive(powerX, powerY);
        this.motorSystem.updateMotors();
    }

    public void driveTurnLeft(double power) {
        super.driveTurnLeft(power);
        this.motorSystem.updateMotors();
    }

    public void driveTurnRight(double power) {
        super.driveTurnRight(power);
        this.motorSystem.updateMotors();
    }

    public void setClawState(ClawState clawState) {
        super.setClawState(clawState);
        this.servoSystem.updateServos();
    }

    public void moveArm(double power) {
        super.moveArm(power);
        this.motorSystem.updateMotors();
    }

    public void stopMotion() {
        super.stopMotion();
        this.motorSystem.updateMotors();
    }
}
