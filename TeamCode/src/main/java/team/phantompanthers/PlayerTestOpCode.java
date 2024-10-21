package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * <h1>PlayerTestOpCode Documentation</h1>
 * A TeleOp OpMode for controlling a robot during the Driver Controlled period.
 * robot functionality using player input from a gamepad.
 * <p>
 * It provides basic telemetry feedback and responds to gamepad joystick input.
 */
@TeleOp()
public class PlayerTestOpCode extends OpMode {

    public void init() {
        telemetry.addData("We Are Live...",":3");
    }

    public void loop() {
        //  Left Stick Registers in Left Direction
        //  -1 <---0
      if(gamepad1.left_stick_x < 0){
          telemetry.addData("Left Stick","Received to the left");
      } else if (gamepad1.left_stick_x > 0) {
          //Left Stick Registers in Right Direction
          telemetry.addData("Left Stick", "Received to the Right");
      }
      telemetry.addData("GamePad Left Stick",gamepad1.left_stick_x);
    }
}
