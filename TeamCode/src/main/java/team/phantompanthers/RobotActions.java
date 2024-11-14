package team.phantompanthers;

public class RobotActions {

    /**
     * Raise or lower the arms of the robot.
     *
     * @param position The speed at which to raise or lower it at. Negative power lowers it, positive power raises it.
     * @param time  The time to raise for.
     */
    public static void raiseArm(ServoOBJSystem servoSystem, double position, long time) {
        servoSystem.setPosition("robotic_arm", position);
        if (time > 0) {
            servoSystem.updateMotors();
            sleep(time);
        }
    }

    /**
     * Extend or retract the arm.
     *
     * @param position is the position the servo will go
     * The speed at which to extend the arm at. Negative power retracts it, positive power extends it.
     * @param time  The time to extend or retract for.
     * @param armExtender   The arm to extend or retract.
     */
    public static void extendArm(ServoOBJSystem servoSystem, double position, long time, String armExtender) {
        servoSystem.setPosition(armExtender, position);
        if (time > 0) {
            servoSystem.updateMotors();
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
