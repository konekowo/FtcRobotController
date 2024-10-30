package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "PlayerOpCode", group = "Linear Opmode")
public class PlayerOpCode extends ExtendableArmsPlayerOpCode {
    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param gamepad -> Gamepad of the Robot
     */
    public PlayerOpCode(Gamepad gamepad) {
        super(gamepad);
        runOpMode();
    }

    /**
     * What Will Run During Op Mode
     */
    @Override
    public void runOpMode() {
        // Maps Motors to their Name
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");
        motorSystem.addMotor("arm_extender");
        motorSystem.addMotor("robotic_arm");


        // Will Run when Init Is Pressed
        waitForStart();
        while (opModeIsActive()) {
            // This is a masterpiece trust
            telemetry.addData("Hawk Tuah", "Spit on that thang!");
            driveForward(ControlMappings.FORWARD.getFloat(gamepad1), 0);
            driveBackward(ControlMappings.BACKWARD.getFloat(gamepad1), 0);
            driveLeft(ControlMappings.LEFT.getFloat(gamepad1), 0);
            driveRight(ControlMappings.RIGHT.getFloat(gamepad1), 0);
            raiseArm(ControlMappings.RAISE_ARM.getFloat(gamepad1), 0, roboticArm,roboticArm2);
            lowerArm(ControlMappings.LOWER_ARM.getFloat(gamepad1),0,roboticArm,roboticArm2);
        }
    }
}
