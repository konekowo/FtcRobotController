package team.phantompanthers.opcodes.auto_op;

import androidx.core.math.MathUtils;

import team.phantompanthers.RobotActions;
import team.phantompanthers.Vector2f;
import team.phantompanthers.part_specific.ClawState;
import team.phantompanthers.part_specific.MotorSystem;
import team.phantompanthers.part_specific.ServoSystem;

public class AutoOpRobotActions extends RobotActions {

    protected static final float DRIVE_METERS_PER_SECOND = 1.5f;
    protected static final float DRIVE_TURN_ROTATIONS_PER_SECOND = 1f;

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
     * @return The amount of time in milliseconds it will take for the robot to reach the given distance. (This is for pausing the application after this method.)
     */
    public long drive(Vector2f direction, double meters) {
        direction.setX(MathUtils.clamp(direction.getX(), 0f, 1f));
        direction.setY(MathUtils.clamp(direction.getY(), 0f, 1f));
        super.drive(direction.getX(), direction.getY());
        this.motorSystem.updateMotors();
        return Math.round((meters / DRIVE_METERS_PER_SECOND) * 1000);
    }

    public void driveTurnLeft(double power) {
        super.driveTurnLeft(power);
        this.motorSystem.updateMotors();
    }

    /**
     * Rotate the robot counter clockwise by a given amount of degrees.
     *
     * @param degrees The degrees to rotate the robot by.
     * @return The time in milliseconds it will take to rotate the robot by the given amount of degrees. (This is for pausing the application after this method.)
     */
    public long driveTurnLeft(double power, double degrees) {
        super.driveTurnLeft(power);
        this.motorSystem.updateMotors();
        return Math.round(((degrees / 360D) / (DRIVE_TURN_ROTATIONS_PER_SECOND * power)) * 1000);
    }

    public void driveTurnRight(double power) {
        super.driveTurnRight(power);
        this.motorSystem.updateMotors();
    }

    /**
     * Rotate the robot clockwise by a given amount of degrees.
     *
     * @param degrees The degrees to rotate the robot by.
     * @return The time in milliseconds it will take to rotate the robot by the given amount of degrees. (This is for pausing the application after this method.)
     */
    public long driveTurnRight(double power, double degrees) {
        super.driveTurnRight(power);
        this.motorSystem.updateMotors();
        return Math.round(((degrees / 360D) / (DRIVE_TURN_ROTATIONS_PER_SECOND * power)) * 1000);
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
