package team.phantompanthers.opcodes.auto_op;

import androidx.core.math.MathUtils;

import team.phantompanthers.RobotActions;
import team.phantompanthers.Vector2f;
import team.phantompanthers.part_specific.ClawState;
import team.phantompanthers.part_specific.MotorSystem;
import team.phantompanthers.part_specific.ServoSystem;

public class AutoOpRobotActions extends RobotActions {

    protected static final float DRIVE_METERS_PER_SECOND = 1.5f;

    public AutoOpRobotActions(MotorSystem motorSystem, ServoSystem servoSystem) {
        super(motorSystem, servoSystem);
    }

    public void drive(double powerX, double powerY) {
        super.drive(powerX, powerY);
        this.motorSystem.updateMotors();
    }

    /**
     * Drive in a given direction for a given amount of meters.
     *
     * @param direction The direction to drive in as a 2D Vector. (values under 1 = drive slower, values are clamped from 0 to 1)
     * @param meters    The amount of meters to drive for.
     * @return The amount of time in milliseconds it will take to reach the given distance. (This is for pausing the application after this method.)
     */
    public long drive(Vector2f direction, double meters) {
        direction.setX(MathUtils.clamp(direction.getX(), 0f, 1f));
        direction.setY(MathUtils.clamp(direction.getY(), 0f, 1f));
        super.drive(direction.getX(), direction.getY());
        long timeMS = Math.round((meters / DRIVE_METERS_PER_SECOND) * 1000);
        this.motorSystem.updateMotors();
        return timeMS;
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
