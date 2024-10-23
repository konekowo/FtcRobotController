package team.phantompanthers;

import com.qualcomm.robotcore.hardware.Gamepad;

public class PlayerOpCode extends ExtendableArmsPlayerOpCode{
    /**
     * When The Class in Initialize This Constructor will run the OpMode.
     *
     * @param gamepad -> Gamepad of the Robot
     */
    public PlayerOpCode(Gamepad gamepad) {
        super(gamepad);
    }
    @Override
    public void runOpMode() {
        float Forward = Controls.getFloat(gamepad1,ControlMappings.FORWARD);
        float Backward = Controls.getFloat(gamepad1,ControlMappings.BACKWARD);
        float Left = Controls.getFloat(gamepad1,ControlMappings.LEFT);
        float Right = Controls.getFloat(gamepad1,ControlMappings.RIGHT);

       waitForStart();
       while(opModeIsActive()) {
           driveForward(Forward,0);
           driveBackward(Backward,0);
           driveLeft(Left,0);
           driveRight(Right,0);
       }
    }
}
