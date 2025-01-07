package team.phantompanthers.opcodes.player.impl;

//TODO: Screw holes in the wood with the numbers, change the password on the RC

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import team.phantompanthers.ControlMappings;
import team.phantompanthers.RobotActions;
import team.phantompanthers.opcodes.player.PlayerOpCodeBase;

@TeleOp(name = "IntoTheDeep", group = "Linear Opmode")
public class PlayerOpCode extends PlayerOpCodeBase {
    private boolean gripClawToggle = true;
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
            if (ControlMappings.GRIP_CLAW.getBoolean(gamepad1)) {
                gripClawToggle = !gripClawToggle;
                RobotActions.sleep(200L);
            }
            RobotActions.drive(motorSystem, ControlMappings.MOVEMENT_X.getFloat(gamepad1),
                    ControlMappings.MOVEMENT_Y.getFloat(gamepad1), 0);
            RobotActions.driveTurnLeft(motorSystem, ControlMappings.TURN_LEFT.getFloat(gamepad1), 0);
            RobotActions.driveTurnRight(motorSystem, ControlMappings.TURN_RIGHT.getFloat(gamepad1), 0);
            RobotActions.verticalClaws(servoSystem, gripClawToggle);
            RobotActions.moveArm(motorSystem, -ControlMappings.RAISE_ARM.getFloat(gamepad1), 0);
            motorSystem.updateMotors();
            servoSystem.updateMotors();
        }
    }
}
