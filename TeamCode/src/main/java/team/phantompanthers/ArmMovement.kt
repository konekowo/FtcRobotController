package team.phantompanthers

import com.qualcomm.robotcore.hardware.DcMotor

/**
 * Basic Motion for Arm Movement to Raise And Lower Arm for set amount of time
 *
 * Also For Extending the Robot Arms.
 */
interface ArmMovement : Movement {
    /**
     * @param power is the speed of the robot arm
     * @param time is the duration of the robot arm raising
     * @param arm is the motor of the robot arm.
     * @param arm2 is the motor of the robot arm.
     */
    fun raiseArm(power: Double, time: Long, arm: DcMotor, arm2: DcMotor)

    /**
     * @param power is the speed of the robot arm lowering
     * @param time is the duration of the robot arm lowering
     * @param arm is the motor of the robot arm.
     * @param arm2 is the motor of the robot arm.
     */
    fun lowerArm(power: Double, time: Long, arm: DcMotor, arm2: DcMotor)

    /**
     * @param power is the speed of the robot arm extending
     * @param time is the duration of the robot arm extending
     * @param arm is the motor of the robot arm.
     * @param arm2 is the motor of the robot arm.
     */
    fun extendArm(power: Double, time: Long, arm: DcMotor, arm2: DcMotor)
}