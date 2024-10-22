package team.phantompanthers

/**
 * Basic Motion for Arm Movement to Raise And Lower Arm for set amount of time
 *
 * Also For Extending the Robot Arms.
 */
interface ArmMovement : Movement{
    /**
     * @param power is the speed of the robot arm
     * @param time is the duration of the robot arm
     */
    fun raiseArm(power: Double, time: Long)

    /**
     * @param power is the speed of the robot arm lowering
     * @param time is the duration of the robot arm lowering
     */
    fun lowerArm(power: Double, time: Long)
    /**
     * @param power is the speed of the robot arm extending
     * @param time is the duration of the robot arm extending
     */
    fun extendArm(power: Double, time: Long)
}