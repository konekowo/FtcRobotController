package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * <h1>PlayerTestOpCode Documentation</h1>
 * A TeleOp OpMode for controlling a robot during the Driver Controlled period.
 * robot functionality using player input from a gamepad.
 * <p>
 * It provides basic telemetry feedback and responds to gamepad joystick input.
 */
@TeleOp()
public class PlayerTestOpCode extends LinearOpMode {
    Gamepad gamepad;
    public PlayerTestOpCode(Gamepad gamepad){

    }
    @Override
    public void runOpMode() throws InterruptedException {
    }
}
