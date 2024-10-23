package team.phantompanthers

import com.qualcomm.robotcore.hardware.DcMotor

/**
 * <h1>TurnOpCode Documentation</h1>
 * OpCode for Turning The Robot left or right.
 *
 * @param leftPower -> power of the left motor
 * @param rightPower -> power of the right motor
 * @param turnPower -> How far the robot turns
 * @param drivePower -> Speed of the Robot Drives While Turning
 * @param time -> Duration of the Turn
 * @param leftDrive -> Left Motor of the Robot
 * @param rightDrive -> Right Motor of the Robot
 */
class TurnOpCode(leftPower : Double, rightPower : Double, turnPower: Double, drivePower: Double, time: Long,leftDrive: DcMotor, rightDrive: DcMotor){
    fun leftTurn(){

    }
    fun rightTurn(){

    }
}