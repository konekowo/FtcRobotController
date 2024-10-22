package team.phantompanthers

/**
 * Basic Motion for Arm Movement to Raise And Lower Arm for set amount of time
 *
 * Also For Extending the Robot Arms.
 */
interface ArmMovement : Movement{
    fun raiseArm(power: Double, time: Long)
    fun lowerArm(power: Double, time: Long)
    fun extendArm(power: Double, time: Long)
}