package team.phantompanthers;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.jetbrains.annotations.NotNull;

public class RobotActions {

    /**
     * Raise or Lower the arms of the robot.
     * @param power The speed at which to raise or lower it at. Negative power lowers it, positive power raises it.
     * @param time The time to raise for.
     * @param arm The robotic arm to raise or lower.
     */
    public static void raiseOrLowerArm(double power, long time, DcMotor arm) {
        if (arm != null) {
            arm.setPower(power);
        }
        if (time > 0) {
            sleep(time);
        }
    }

    /**
     * Extend the arm.
     * @param power The speed at which to extend the arm at. Negative power unextends it, positive power extends it.
     * @param time The time to extend for.
     * @param arm The arm to extend.
     */
    public static void extendArm(double power, long time, DcMotor arm) {
        arm.setPower(power);
        if (time > 0) {
            sleep(time);
        }
    }

    public static void driveForward(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        if (time > 0) {
            sleep(time);
        }
    }

    public static void driveBackward(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("top_left_motor", -power);
        motorSystem.setPower("top_right_motor", -power);
        motorSystem.setPower("bottom_left_motor", -power);
        motorSystem.setPower("bottom_right_motor", -power);
        if (time > 0) {
            sleep(time);
        }
    }

    /**
     * Stops all motion on all motors.
     * @param motorSystem The MotorSystem to stop all motors on.
     */
    public static void stopMotion(MotorSystem motorSystem) {
        motorSystem.setPower("top_left_motor", 0);
        motorSystem.setPower("top_right_motor", 0);
        motorSystem.setPower("bottom_left_motor", 0);
        motorSystem.setPower("bottom_right_motor", 0);
    }

    public static void driveLeft(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        if (time > 0) {
            sleep(time);
        }
    }

    public static void driveRight(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        if (time > 0) {
            sleep(time);
        }
    }

    /**
     * Suspends the current thread.
     * @param milliseconds The time to suspend the thread for.
     */
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
