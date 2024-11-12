package team.phantompanthers;

public class RobotActions {

    /**
     * Raise or lower the arms of the robot.
     *
     * @param power The speed at which to raise or lower it at. Negative power lowers it, positive power raises it.
     * @param time  The time to raise for.
     * @param arm   The robotic arm to raise or lower.
     */
    public static void raiseArm(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("robotic_arm", power);
        if (time > 0) {
            motorSystem.updateMotors();
            sleep(time);
        }
    }

    /**
     * Extend or retract the arm.
     *
     * @param power The speed at which to extend the arm at. Negative power retracts it, positive power extends it.
     * @param time  The time to extend or retract for.
     * @param arm   The arm to extend or retract.
     */
    public static void extendArm(MotorSystem motorSystem, double power, long time, String armExtender) {
        motorSystem.setPower(armExtender, power);
        if (time > 0) {
            motorSystem.updateMotors();
            sleep(time);
        }
    }

    /**
     * Drive the robot in any direction.
     *
     * @param motorSystem The MotorSystem
     * @param powerX      The x speed
     * @param powerY      The y speed
     * @param time        The time to drive for.
     */
    public static void drive(MotorSystem motorSystem, double powerX, double powerY, long time) {
        motorSystem.setPower("top_left_motor", powerY * powerX);
        motorSystem.setPower("top_right_motor", powerY * -powerX);
        motorSystem.setPower("bottom_left_motor", powerY * powerX);
        motorSystem.setPower("bottom_right_motor", powerY * -powerX);
        if (time > 0) {
            motorSystem.updateMotors();
            sleep(time);
        }
    }

    /**
     * Stops all motion on all motors.
     *
     * @param motorSystem The MotorSystem to stop all motors on.
     */
    public static void stopMotion(MotorSystem motorSystem) {
        motorSystem.setPower("top_left_motor", 0);
        motorSystem.setPower("top_right_motor", 0);
        motorSystem.setPower("bottom_left_motor", 0);
        motorSystem.setPower("bottom_right_motor", 0);
        motorSystem.updateMotors();
    }

    /**
     * Rotates the robot to the left.
     *
     * @param motorSystem The MotorSystem
     * @param power       The speed to turn at.
     * @param time        The time to turn for.
     */
    public static void driveTurnLeft(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        motorSystem.setPower("top_left_motor",
                motorSystem.getPower("top_left_motor") * (1 - power));
        motorSystem.setPower("bottom_right_motor",
                motorSystem.getPower("bottom_right_motor") * (1 - power));
        if (time > 0) {
            motorSystem.updateMotors();
            sleep(time);
        }
    }

    /**
     * Rotates the robot to the right.
     *
     * @param motorSystem The MotorSystem
     * @param power       The speed to turn at.
     * @param time        The time to turn for.
     */
    public static void driveTurnRight(MotorSystem motorSystem, double power, long time) {
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        motorSystem.setPower("top_right_motor",
                motorSystem.getPower("top_right_motor") * (1 - power));
        motorSystem.setPower("bottom_left_motor",
                motorSystem.getPower("bottom_left_motor") * (1 - power));
        if (time > 0) {
            motorSystem.updateMotors();
            sleep(time);
        }
    }

    /**
     * Suspends the current thread.
     *
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
