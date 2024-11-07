package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.jetbrains.annotations.NotNull;

/**
 * <h1>ExtendableArmsPlayerOpCode Documentation</h1>
 * ExtendableArmsPlayerCode is for the Robot Is In TeleOp Mode and Extends it's Arm.
 * It Extends PlayerOpCode and adds Manual Controls.
 */
@TeleOp(name = "ExtendableArmsPlayerOpCode", group = "Linear Opmode")
public class ExtendableArmsPlayerOpCode extends PlayerTestOpCode implements ArmMovement {
    DcMotor roboticArm;
    DcMotor roboticArm2;

    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param gamepad -> Gamepad of the Robot
     */

    /**
     * What Will Run During Op Mode
     */

    @Override
    public void raiseArm(double power, long time, @NotNull DcMotor arm, @NotNull DcMotor arm2) {
        arm.setPower(power);
        arm2.setPower(power);
        if (time > 0) {
            sleep(time);
        }
    }

    @Override
    public void lowerArm(double power, long time, @NotNull DcMotor arm, @NotNull DcMotor arm2) {
        arm.setPower(power);
        arm2.setPower(power);
        if (time > 0) {
            sleep(time);
        }
    }

    @Override
    public void extendArm(double power, long time, @NotNull DcMotor arm, @NotNull DcMotor arm2) {
        arm.setPower(power);
        arm2.setPower(power);
        if (time > 0) {
            sleep(time);
        }
    }

    @Override
    public void driveForward(double power, long time) {
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        if (time > 0) {
            sleep(time);
        }
    }

    @Override
    public void driveBackward(double power, long time) {
        motorSystem.setPower("top_left_motor", -power);
        motorSystem.setPower("top_right_motor", -power);
        motorSystem.setPower("bottom_left_motor", -power);
        motorSystem.setPower("bottom_right_motor", -power);
        if (time > 0) {
            sleep(time);
        }
    }

    @Override
    public void stopMotion(){
        motorSystem.setPower("top_left_motor", 0);
        motorSystem.setPower("top_right_motor", 0);
        motorSystem.setPower("bottom_left_motor", 0);
        motorSystem.setPower("bottom_right_motor", 0);
    }

    @Override
    public void driveLeft(double power, long time) {
        motorSystem.setPower("top_left_motor", power);
        motorSystem.setPower("bottom_right_motor", power);
        if (time > 0) {
            sleep(time);
        }
    }

    @Override
    public void driveRight(double power, long time) {
        motorSystem.setPower("top_right_motor", power);
        motorSystem.setPower("bottom_left_motor", power);
        if (time > 0) {
            sleep(time);
        }
    }
    
    
}
