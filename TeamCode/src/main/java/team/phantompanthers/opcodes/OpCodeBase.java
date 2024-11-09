package team.phantompanthers.opcodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import team.phantompanthers.MotorSystem;

public abstract class OpCodeBase extends LinearOpMode {
    protected MotorSystem motorSystem;

    /**
     * Initiates the motor system for use.
     * Please call this method in runOpMode()!!
     */
    protected void initMotorSystem() {
        motorSystem = new MotorSystem(hardwareMap, telemetry);
        motorSystem.addMotor("top_left_motor", true);
        motorSystem.addMotor("top_right_motor", true);
        motorSystem.addMotor("bottom_left_motor", false);
        motorSystem.addMotor("bottom_right_motor", true);
        motorSystem.addMotor("robotic_arm", false);
        // motorSystem.addMotor("robotic_extender",false);
    }

}
