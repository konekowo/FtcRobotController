package team.phantompanthers;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * <h1>AutoOpCode Documentation</h1>
 * The Actual TeleOp Code for the FTC Into the deep for the Phantom Panthers,
 */
@Autonomous(name = "AutoOpCode", group = "Linear Opmode")
public class AutoOpCode extends ExtendableArmsAutoOpCode {

    @Override
    public void runOpMode() {
        initMotorSystem();
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");

        // Will Run when Init Is Pressed
        waitForStart();
        while (opModeIsActive()) {
            driveForward(1.0, 3);
            driveLeft(1.0, 3);
            driveRight(1.0, 3);
            driveBackward(1.0, 3);
        }
    }
}
