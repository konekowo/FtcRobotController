package team.phantompanthers

/**
 * Basic Motion Interface for a Forward, BackWard, And Stop.
 *
 * Please DO NOT Mess With The Params But You May Add other Movement Functions.
 */
interface Movement{
    fun driveForward(power: Double, time: Long)
    fun driveBackward(power: Double, time:Long)
    fun stopMotion()
}