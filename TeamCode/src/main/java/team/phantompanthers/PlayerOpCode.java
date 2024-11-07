package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "IntoTheDeep", group = "Linear Opmode")
public class PlayerOpCode extends ExtendableArmsPlayerOpCode {
    /**
     * What Will Run During Op Mode
     */
    @Override
    public void runOpMode() {
        initMotorSystem();

        // Maps Motors to their Name
        motorSystem.addMotor("top_left_motor");
        motorSystem.addMotor("top_right_motor");
        motorSystem.addMotor("bottom_left_motor");
        motorSystem.addMotor("bottom_right_motor");
        //motorSystem.addMotor("arm_extender");
        //motorSystem.addMotor("robotic_arm");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Will Run when Init Is Pressed
        waitForStart();
        resetRuntime();
        while (opModeIsActive()) {
            driveForward(ControlMappings.FORWARD.get(Float.class, gamepad1), 0);
            driveBackward(ControlMappings.BACKWARD.get(Float.class, gamepad1), 0);
            driveLeft(ControlMappings.LEFT.get(Float.class, gamepad1), 0);
            driveRight(ControlMappings.RIGHT.get(Float.class, gamepad1), 0);
            //raiseArm(ControlMappings.RAISE_ARM.getFloat(gamepad1), 0, roboticArm, roboticArm2);
            //lowerArm(ControlMappings.LOWER_ARM.getFloat(gamepad1), 0, roboticArm, roboticArm2);
        }
    }
}
