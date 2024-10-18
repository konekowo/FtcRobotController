package team.phantompanthers

interface Movement{
    fun driveForward(power: Double, time: Long)
    fun driveBackward(power: Double, time:Long)
    fun stopMotion()
}