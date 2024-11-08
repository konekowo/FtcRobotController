package team.phantompanthers.opcodes.player.impl;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import team.phantompanthers.ControlMappings;
import team.phantompanthers.opcodes.player.PlayerOpCodeBase;
import team.phantompanthers.RobotActions;

@TeleOp(name = "IntoTheDeep", group = "Linear Opmode")
public class PlayerOpCode extends PlayerOpCodeBase {
    /**
     * What Will Run During Op Mode
     */
    @Override
    public void runOpMode() {
        initMotorSystem();

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Will Run when Init Is Pressed
        waitForStart();
        resetRuntime();
        while (opModeIsActive()) {
            RobotActions.driveForward(motorSystem, ControlMappings.FORWARD.getFloat(gamepad1), 0);
            RobotActions.driveBackward(motorSystem, ControlMappings.BACKWARD.getFloat(gamepad1), 0);
            RobotActions.driveTurnLeft(motorSystem, ControlMappings.LEFT.getFloat(gamepad1), 0);
            RobotActions.driveTurnRight(motorSystem, ControlMappings.RIGHT.getFloat(gamepad1), 0);
            //RobotActions.raiseArm(motorSystem, ControlMappings.RAISE_ARM.getFloat(gamepad1), 0, roboticArm, roboticArm2);
            //RobotActions.lowerArm(motorSystem, ControlMappings.LOWER_ARM.getFloat(gamepad1), 0, roboticArm, roboticArm2);
        }
    }
}
