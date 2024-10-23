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
@TeleOp(name="ExtendableArmsPlayerOpCode", group="Linear Opmode")
public class ExtendableArmsPlayerOpCode extends PlayerTestOpCode implements ArmMovement{
    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor roboticArm;


    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param gamepad -> Gamepad of the Robot
     */
    public ExtendableArmsPlayerOpCode(Gamepad gamepad) {
        super(gamepad);
        runOpMode();
    }

    /**
     * What Will Run During Op Mode
     */
    @Override
    public void runOpMode(){
        // TODO: Find a Way to make power run until lack of input //
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");
        roboticArm = hardwareMap.get(DcMotor.class, "robotic_Arm");

        // Will Run when Init Is Pressed
        waitForStart();
        while(opModeIsActive()) {

            if (gamepad.a) {
                telemetry.addData("Arm Status", "Rising");
                raiseArm(1.0, 1000, roboticArm);
            }
            if (gamepad.b) {
                telemetry.addData("Arm Status", "Lowering");
                lowerArm(1.0, 1000, roboticArm);
            }
            if (gamepad.x) {
                telemetry.addData("Arm Status", "Extending");
                extendArm(1.0, 1000, roboticArm);
            }
            if (gamepad.left_stick_y < 0) {
                telemetry.addData("Drive Status", "Moving Forward");
                driveBackward(3.0, 500);
            }
            if (gamepad.left_stick_y > 0) {
                telemetry.addData("Drive Status", "Moving Backward");
                driveForward(3.0, 500);
            }
            if (gamepad.right_bumper && gamepad.left_bumper) {
                telemetry.addData("Drive Status", "Stopping");
                stopMotion();
            }
        }
    }

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
     leftMotor.setPower(power);
     rightMotor.setPower(power);
     sleep(time);
    }

    @Override
    public void driveBackward(double power, long time) {
        leftMotor.setPower(-power);
        rightMotor.setPower(-power);
        sleep(time);
    }

    @Override
    public void stopMotion() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
