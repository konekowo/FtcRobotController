package team.phantompanthers

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.HardwareMap
/**
 * This Class is a more easier way of adding motors to the robot.
 * @param hardwareMap Hardware Map of the Motor
 */
class MotorSystem(private val hardwareMap: HardwareMap){
    private val motors: MutableMap<String, DcMotor> = HashMap()

    /**
     * Assigns a MotorName to the Motor, and adds it to the HashMap.
     * @param motorName Name of the Motor
     */
    fun addMotor(motorName: String){
        val motor = hardwareMap.get(DcMotor::class.java, motorName)
        motors[motorName] = motor
    }

    /**
     * returns the motor name
     * @param motorName Name of the Motor
     */

    fun getMotor(motorName: String): DcMotor?{
        return motors[motorName]
    }
    /**
     * Sets the power of the motor
     * @param motorName Name of the Motor
     * @param power Power of the Motor
     */
    fun setPower(motorName: String, power: Double){
        val motor = motors[motorName] ?: return
        motor.power = power
    }
    /**
     * Stops the motor
     * @param motorName Name of the Motor
     */
    fun stop(motorName: String){
        motors.remove(motorName)
    }

}