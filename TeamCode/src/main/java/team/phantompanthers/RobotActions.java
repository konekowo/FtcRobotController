package team.phantompanthers;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.jetbrains.annotations.NotNull;

import team.phantompanthers.part_specific.ClawState;
import team.phantompanthers.part_specific.MotorSystem;
import team.phantompanthers.part_specific.ServoSystem;

public abstract class RobotActions {
    protected final MotorSystem motorSystem;
    protected final ServoSystem servoSystem;

    public RobotActions(MotorSystem motorSystem, ServoSystem servoSystem) {
        this.motorSystem = motorSystem;
        this.servoSystem = servoSystem;
    }

    /**
     * Drive the robot in any direction.
     * @param powerX The x-speed at which the robot drives in.
     * @param powerY The y-speed at which the robot drives in.
     */
    public void drive(double powerX, double powerY) {
        motorSystem.setPower("top_left_motor", MathUtils.clamp(-powerX + powerY, -1, 1));
        motorSystem.setPower("top_right_motor", -MathUtils.clamp(-powerX - powerY, -1, 1));
        motorSystem.setPower("bottom_left_motor", -MathUtils.clamp(-powerX - powerY, -1, 1));
        motorSystem.setPower("bottom_right_motor", MathUtils.clamp(-powerX + powerY, -1, 1));
    }

    /**
     * Rotate the robot counterclockwise.
     * @param power The speed at which the robot rotates.
     */
    public void driveTurnLeft(double power) {
        if (power > 0) {
            motorSystem.setPower("top_left_motor", power);
            motorSystem.setPower("bottom_left_motor", power);
            motorSystem.setPower("top_right_motor", -power);
            motorSystem.setPower("bottom_right_motor", -power);
        }
    }

    /**
     * Rotate the robot clockwise.
     * @param power The speed at which the robot rotates.
     */
    public void driveTurnRight(double power) {
        if (power > 0) {
            motorSystem.setPower("top_right_motor", power);
            motorSystem.setPower("bottom_right_motor", power);
            motorSystem.setPower("top_left_motor", - power);
            motorSystem.setPower("bottom_left_motor", -power);
        }
    }

    /**
     * Move the arm up or down.
     * @param power The speed at which to move the arm.
     */
    public void moveArm(double power) {
        motorSystem.setPower("arm_motor", -(power / 2f));
    }

    /**
     * Open or close the claw.
     * @param clawState Whether to open or close the claw.
     */
    public void setClawState(ClawState clawState){
        servoSystem.setPosition("claw", clawState == ClawState.CLOSE ? 0.6D : 0.1D);
    }

    /**
     * Stop all motion on all motors.
     */
    public void stopMotion() {
        for (DcMotor motor : motorSystem.getMotors()) {
            motorSystem.setPower(motor.getDeviceName(), 0);
        }
    }

    /**
     * Suspend the current thread for a specified amount of time.
     * @param time The time in time to suspend the current thread for.
     */
    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
