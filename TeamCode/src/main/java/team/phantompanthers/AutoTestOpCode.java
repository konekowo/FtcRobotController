package team.phantompanthers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class AutoTestOpCode extends LinearOpMode implements Movement {

    public AutoTestOpCode(DcMotor leftMotor,DcMotor rightMotor){
        runOpMode();
    }
        DcMotor leftMotor;
        DcMotor rightMotor;

    public void runOpMode() {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        waitForStart();
        if (opModeIsActive()) {
            driveForward(1.0,2000);

            stopMotion();
            sleep(1000);

            driveBackward(1.0,2000);
            stopMotion();
        }
    }

    public void driveForward(double power, long time) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
        sleep(time);
    }

    public void driveBackward(double power, long time) {
      leftMotor.setPower(-power);
      rightMotor.setPower(-power);
      sleep(time);
    }

    public void stopMotion() {
      leftMotor.setPower(0);
      rightMotor.setPower(0);
    }
}

