package team.phantompanthers;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * <h1>AutoOpCode Documentation</h1>
 * The Actual TeleOp Code for the FTC Into the deep for the Phantom Panthers,
 */
@Autonomous(name = "AutoOpCode", group = "Linear Opmode")
public class AutoOpCode extends AutoTestOpCode{

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
            RobotActions.driveForward(motorSystem, 1.0, 3);
            RobotActions.driveLeft(motorSystem, 1.0, 3);
            RobotActions.driveRight(motorSystem, 1.0, 3);
            RobotActions.driveBackward(motorSystem, 1.0, 3);
        }
    }
}
