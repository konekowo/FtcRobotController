package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.jetbrains.annotations.NotNull;

/*
 * <h1>ExtendableArmsAutoOpCode Documentation</h1>
 * This Class is for the for the Robot Is In Autonomous Mode and Extends it's Arm.
 *
 */
@Autonomous
public class ExtendableArmsAutoOpCode extends AutoTestOpCode implements ArmMovement {
    DcMotor roboticArm;
    DcMotor armExtender;

    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param leftMotor  -> Left Motor of the Robot
     * @param rightMotor -> Right Motor of the Robot
     * @param roboticArm -> Arm of the Robot
     */
    public ExtendableArmsAutoOpCode(DcMotor leftMotor, DcMotor rightMotor, DcMotor roboticArm) throws InterruptedException {
        super(leftMotor, rightMotor);
        runOpMode();
    }


    /**
     * FTC Robot Controller
     * Happens During Init Is Pressed
     */
    @Override
    public void runOpMode() {
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");

        // Will Run when Init Is Pressed
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Arm Status", "...Activated");
        }
    }

    /**
     * FTC Robot Controller
     * Rising The Arm
     *
     * @param power -> power of the arm
     * @param time  -> Duration of the arm
     * @param arm   -> arm of the robot
     */
    @Override
    public void raiseArm(double power, long time, @NotNull DcMotor arm) {
        arm.setPower(power);
        sleep(time);
    }

    /**
     * FTC Robot Controller
     * Lowering the Arm.
     *
     * @param power -> power of the arm
     * @param time  -> Duration of the arm
     * @param arm   -> Arm of the Robot
     */
    @Override
    public void lowerArm(double power, long time, @NotNull DcMotor arm) {
        arm.setPower(-power);
        sleep(time);
    }

    /**
     * FTC Robot Controller
     *
     * @param power -> Power of Extension
     * @param time  -> Duration of Extension
     * @param arm   -> Arm of the Robot
     */
    @Override
    public void extendArm(double power, long time, @NotNull DcMotor arm) {
        arm.setPower(power);
        sleep(time);
    }

    /**
     * FTC Robot Controller
     * @param power -> power of the robot movement
     * @param time -> Duration of the movement
     */
    @Override
    public void driveLeft(double power, long time) {
        telemetry.addData("Left Motor Turn", power);
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        sleep(time);
        sleep(time);
    }

    /**
     * FTC Robot Controller
     * @param power -> power of the robot movement
     * @param time -> Duration of the movement
     */
    @Override
    public void driveRight(double power, long time) {
        telemetry.addData("Right Motor Turn", power);
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        sleep(time);
    }
}
