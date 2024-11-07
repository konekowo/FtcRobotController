package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * <h1>PlayerTestOpCode Documentation</h1>
 * A TeleOp OpMode for controlling a robot during the Driver Controlled period.
 * robot functionality using player input from a gamepad.
 * <p>
 * It provides basic telemetry feedback and responds to gamepad joystick input.
 */
public abstract class PlayerTestOpCode extends LinearOpMode {
    protected MotorSystem motorSystem;

    /**
     * Initiates the motor system for use.
     * Please call this method in runOpMode()!!
     */
    protected void initMotorSystem() {
        motorSystem = new MotorSystem(hardwareMap, telemetry);
    }


    @Override
    public void runOpMode() {

    }
}
