package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// Code for the Operator Mode
@TeleOp()
public class TestOpCode extends OpMode {

    public void init() {
      telemetry.addData("Hello","World");
    }

    public void loop() {

    }
}
