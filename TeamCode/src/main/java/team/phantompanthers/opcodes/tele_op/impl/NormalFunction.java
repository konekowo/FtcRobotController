package team.phantompanthers.opcodes.tele_op.impl;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import team.phantompanthers.ControlMappings;
import team.phantompanthers.opcodes.tele_op.TeleOpCodeBase;
import team.phantompanthers.part_specific.ClawState;

@TeleOp(name = "Normal Function", group = "Linear Opmode")
public class NormalFunction extends TeleOpCodeBase {
    private boolean gripClawToggle = true;
    private boolean lastGripClawButtonPressed = false;

    @Override
    public void runOpMode() {
        super.runOpMode();
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Will Run when Init Is Pressed
        waitForStart();
        resetRuntime();
        while (opModeIsActive()) {
            boolean isGripClawButtonPressed = ControlMappings.GRIP_CLAW.getBoolean(gamepad1);

            // on GRIP_CLAW button down
            if (isGripClawButtonPressed != lastGripClawButtonPressed && isGripClawButtonPressed) {
                gripClawToggle = !gripClawToggle;
            }

            telemetry.addData("X", ControlMappings.MOVEMENT_X.getFloat(gamepad1));
            telemetry.addData("Y", ControlMappings.MOVEMENT_Y.getFloat(gamepad1));
            robotActions.drive(ControlMappings.MOVEMENT_X.getFloat(gamepad1),
                    ControlMappings.MOVEMENT_Y.getFloat(gamepad1));
            robotActions.driveTurnLeft(ControlMappings.TURN_LEFT.getFloat(gamepad1));
            robotActions.driveTurnRight(ControlMappings.TURN_RIGHT.getFloat(gamepad1));
            robotActions.setClawState(gripClawToggle ? ClawState.CLOSE : ClawState.OPEN);
            telemetry.addData("Claw State", (gripClawToggle ? ClawState.CLOSE : ClawState.OPEN).name());
            robotActions.moveArm(ControlMappings.RAISE_ARM.getFloat(gamepad1));
            robotActions.moveHorizArm(ControlMappings.HORIZONTAL_ARM.getFloat(gamepad2));

            motorSystem.updateMotors();
            servoSystem.updateServos();
            telemetry.update();
            lastGripClawButtonPressed = isGripClawButtonPressed;
        }
    }
}
