package team.phantompanthers.opcodes.player.impl;

//TODO: Screw holes in the wood with the numbers, change the password on the RC

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import team.phantompanthers.ControlMappings;
import team.phantompanthers.RobotActions;
import team.phantompanthers.opcodes.OpCodeBase;
import team.phantompanthers.opcodes.player.PlayerOpCodeBase;

@TeleOp(name = "IntoTheDeep", group = "Linear Opmode")
public class PlayerOpCode extends PlayerOpCodeBase {
    /**
     * What Will Run During Op Mode
     */
    @Override
    public void runOpMode() {
        initMotorSystem();

        telemetry.addData("Status", "Initialized");
        telemetry.addData("Current Controller", getCurrentController());
        telemetry.update();
        // Will Run when Init Is Pressed
        waitForStart();
        resetRuntime();
        if(opModeIsActive()){
            telemetry.addData("Status", "Running");
            telemetry.addData("Runtime", getRuntime());
            telemetry.update();
        }
        if(isStopRequested()){
            telemetry.update();
        } else{
            telemetry.addData("Status", "Stopped");
            telemetry.update();
        }
        while (opModeIsActive()) {
            RobotActions.drive(motorSystem, ControlMappings.MOVEMENT_X.getFloat(gamepad1),
                    ControlMappings.MOVEMENT_Y.getFloat(gamepad1), 0);
            RobotActions.driveTurnLeft(motorSystem, ControlMappings.TURN_LEFT.getFloat(gamepad1), 0);
            RobotActions.driveTurnRight(motorSystem, ControlMappings.TURN_RIGHT.getFloat(gamepad1), 0);
            RobotActions.raiseArm(motorSystem, ControlMappings.RAISE_ARM.getFloat(gamepad1), 0);
            motorSystem.updateMotors();
        }
    }
}
