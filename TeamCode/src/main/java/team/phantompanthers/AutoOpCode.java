package team.phantompanthers;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * <h1>AutoOpCode Documentation</h1>
 * The Actual TeleOp Code for the FTC Into the deep for the Phantom Panthers,
 */
@Autonomous(name = "AutoOpCode", group = "Linear Opmode")
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
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");

        // Will Run when Init Is Pressed
        waitForStart();
        while (opModeIsActive()) {
            // TODO: Add Auto Code //
        }
    }
}
