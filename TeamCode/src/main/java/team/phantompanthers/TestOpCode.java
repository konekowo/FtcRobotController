package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// Code for the Operator Mode
@TeleOp()
public class TestOpCode extends OpMode {

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
