package team.phantompanthers;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * <h1>AutoOpCode Documentation</h1>
 * The Actual TeleOp Code for the FTC Into the deep for the Phantom Panthers,
 */
@TeleOp(name = "PlayerOpCode", group = "Linear Opmode")
public class AutoOpCode extends ExtendableArmsAutoOpCode {
    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param leftMotor  -> Left Motor of the Robot
     * @param rightMotor -> Right Motor of the Robot
     * @param roboticArm -> Arm of the Robot
     */
    public AutoOpCode(DcMotor leftMotor, DcMotor rightMotor, DcMotor roboticArm) throws InterruptedException {
        super(leftMotor, rightMotor, roboticArm);
    }

    @Override
    public void runOpMode() {

        // Will Run when Init Is Pressed
        waitForStart();
        while (opModeIsActive()) {

        }
    }
}
