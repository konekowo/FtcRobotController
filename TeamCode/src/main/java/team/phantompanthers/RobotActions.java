package team.phantompanthers;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.jetbrains.annotations.NotNull;

public class RobotActions {
    public static void raiseArm(double power, long time, @NotNull DcMotor arm, @NotNull DcMotor arm2) {
        arm.setPower(power);
        arm2.setPower(power);
        if (time > 0) {
            sleep(time);
        }
    }

    public static void lowerArm(double power, long time, @NotNull DcMotor arm, @NotNull DcMotor arm2) {
        arm.setPower(power);
        arm2.setPower(power);
        if (time > 0) {
            sleep(time);
        }
    }

    public static void extendArm(double power, long time, @NotNull DcMotor arm, @NotNull DcMotor arm2) {
        arm.setPower(power);
        arm2.setPower(power);
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

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
