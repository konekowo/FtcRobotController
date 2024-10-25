package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
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
    MotorSystem motorSystem = new MotorSystem(hardwareMap);

    /**
     * What Will Run During Op Mode
     */
    @Override
    public void runOpMode() {
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");

        float Forward = Controls.getFloat(gamepad1, ControlMappings.FORWARD);
        float Backward = Controls.getFloat(gamepad1, ControlMappings.BACKWARD);
        float Left = Controls.getFloat(gamepad1, ControlMappings.LEFT);
        float Right = Controls.getFloat(gamepad1, ControlMappings.RIGHT);
        boolean Extend = Controls.getBoolean(gamepad1, ControlMappings.EXTEND_ARM);
        boolean Retract = Controls.getBoolean(gamepad1, ControlMappings.RETRACT_ARM);
        boolean Raise = Controls.getBoolean(gamepad1, ControlMappings.RAISE_ARM);
        boolean Lower = Controls.getBoolean(gamepad1, ControlMappings.LOWER_ARM);
        waitForStart();
        while (opModeIsActive()) {
            driveForward(Forward, 0);
            driveBackward(Backward, 0);
            driveLeft(Left, 0);
            driveRight(Right, 0);

            if (Extend) {
                extendArm(1.0, 0, armExtender);
            }
            if (Retract) {
                extendArm(-1.0, 0, armExtender);
            }
            if (Raise) {
                raiseArm(1.0, 0, roboticArm);
            }
            if (Lower) {
                lowerArm(1.0, 0, roboticArm);
            }
        }
    }
}
