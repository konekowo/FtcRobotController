package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "IntoTheDeep", group = "Linear Opmode")
public class PlayerOpCode extends PlayerTestOpCode {
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
            RobotActions.driveForward(motorSystem, ControlMappings.FORWARD.get(Float.class, gamepad1), 0);
            RobotActions.driveBackward(motorSystem, ControlMappings.BACKWARD.get(Float.class, gamepad1), 0);
            RobotActions.driveLeft(motorSystem, ControlMappings.LEFT.get(Float.class, gamepad1), 0);
            RobotActions.driveRight(motorSystem, ControlMappings.RIGHT.get(Float.class, gamepad1), 0);
            //RobotActions.raiseArm(motorSystem, ControlMappings.RAISE_ARM.getFloat(gamepad1), 0, roboticArm, roboticArm2);
            //RobotActions.lowerArm(motorSystem, ControlMappings.LOWER_ARM.getFloat(gamepad1), 0, roboticArm, roboticArm2);
        }
    }
}
