package team.phantompanthers

/**
 * Basic Motion Interface for a Forward, BackWard, And Stop.
 *
 * Please DO NOT Mess With The Params But You May Add other Movement Functions.
 */
interface Movement{
    /**
     * @param power is the speed of the robot
     * @param time  is the duration of the robot
     */
    fun driveForward(power: Double, time: Long)
    /**
     * @param power is the speed of the robot
     * @param time  is the duration of the robot
     */
    fun driveBackward(power: Double, time:Long)
    /**
     * @param leftPower is the speed of the left side of the robot
     * @param rightPower is the speed of the right side of the robot
     * @param time is the duration of the robot
     * @param drive is the the speed of the robot
     * @param time is the duration of the robot
     */
    fun turnLeft(leftPower: Double, rightPower: Double,drive: Double,turn: Double, time: Long)
    /**
     * @param leftPower is the speed of the left side of the robot
     * @param rightPower is the speed of the right side of the robot
     * @param drive is the the speed of the robot
     * @param turn is the drift of the robot
     * @param time is the duration of the robot
     */
    fun turnRight(leftPower: Double,rightPower: Double,drive: Double,turn: Double, time: Long)
    fun stopMotion()
}