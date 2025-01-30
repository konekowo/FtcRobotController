package team.phantompanthers.opcodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import team.phantompanthers.part_specific.MotorSystem;
import team.phantompanthers.part_specific.ServoSystem;

public abstract class OpCodeBase extends LinearOpMode {
    protected MotorSystem motorSystem;
    protected ServoSystem servoSystem;

    @Override
    public void runOpMode() {
        motorSystem = new MotorSystem(hardwareMap, telemetry);
        servoSystem = new ServoSystem(hardwareMap, telemetry);
        motorSystem.addMotor("top_left_motor", true);
        motorSystem.addMotor("top_right_motor", true);
        motorSystem.addMotor("bottom_left_motor", false);
        motorSystem.addMotor("bottom_right_motor", true);
        motorSystem.addMotor("arm_motor", true);
        motorSystem.addMotor("linear_arm", true);
        servoSystem.addMotor("claw");
    }

}
