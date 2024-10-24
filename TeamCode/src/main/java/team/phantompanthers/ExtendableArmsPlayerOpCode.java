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
    DcMotor armExtender;

    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param gamepad -> Gamepad of the Robot
     */
    public ExtendableArmsPlayerOpCode(Gamepad gamepad) {
        super(gamepad);
    }

    /**
     * What Will Run During Op Mode
     */

    @Override
    public void raiseArm(double power, long time, @NotNull DcMotor arm) {
        arm.setPower(power);
        sleep(time);
    }

    @Override
    public void lowerArm(double power, long time, @NotNull DcMotor arm) {
        arm.setPower(power);
        sleep(time);
    }

    @Override
    public void extendArm(double power, long time, @NotNull DcMotor arm) {
        arm.setPower(power);
        sleep(time);
    }

    @Override
    public void driveForward(double power, long time) {
        topLeftMotor.setPower(power);
        topRightMotor.setPower(power);
        bottomLeftMotor.setPower(power);
        bottomRightMotor.setPower(power);
        sleep(time);
    }

    @Override
    public void driveBackward(double power, long time) {
        topLeftMotor.setPower(-power);
        topRightMotor.setPower(-power);
        bottomLeftMotor.setPower(-power);
        bottomRightMotor.setPower(-power);
        sleep(time);
    }

    @Override
    public void stopMotion() {
        topLeftMotor.setPower(0);
        topRightMotor.setPower(0);
        bottomLeftMotor.setPower(0);
        bottomRightMotor.setPower(0);
    }

    @Override
    public void driveLeft(double power, long time) {
        topLeftMotor.setPower(power);
        bottomRightMotor.setPower(power);
        sleep(time);
    }

    @Override
    public void driveRight(double power, long time) {
        topRightMotor.setPower(power);
        bottomLeftMotor.setPower(power);
        sleep(time);
    }
}
