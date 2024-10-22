package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * <h1>ExtendableArmsPlayerOpCode Documentation</h1>
 * ExtendableArmsPlayerCode is for the Robot Is In TeleOp Mode and Extends it's Arm.
 * It Extends PlayerOpCode and adds Manual Controls.
 */
@TeleOp(name="ExtendableArmsPlayerOpCode", group="Linear Opmode")
public class ExtendableArmsPlayerOpCode extends PlayerTestOpCode implements ArmMovement{
    DcMotor leftMotor;
    DcMotor rightMotor;

    public ExtendableArmsPlayerOpCode(Gamepad gamepad) {
        super(gamepad);
    }


    @Override
    public void runOpMode(){
        if(gamepad.a){
            raiseArm(1.0,1000);
        }
        if(gamepad.b){
            lowerArm(1.0,1000);
        }
        if(gamepad.x){
            extendArm(1.0,1000);
        }
        if (gamepad.left_stick_y < 0) {
            driveBackward(3.0,500);
        }
        if (gamepad.left_stick_y > 0) {
            driveForward(3.0,500);
        }
    }
    @Override
    public void raiseArm(double power, long time) {

    }

    @Override
    public void lowerArm(double power, long time) {

    }

    @Override
    public void extendArm(double power, long time) {

    }

    @Override
    public void driveForward(double power, long time) {

    }

    @Override
    public void driveBackward(double power, long time) {

    }

    @Override
    public void stopMotion() {

    }
}
