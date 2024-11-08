package team.phantompanthers

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

/**
 * This Class is a more easier way of adding motors to the robot.
 * @param hardwareMap Hardware Map of the Motor
 */
class MotorSystem(private val hardwareMap: HardwareMap, private val telemetry: Telemetry) {
    private val motors: MutableMap<String, DcMotor> = HashMap()
    private val warnedMotors: MutableList<String> = ArrayList()
    private val reversedMotors: MutableList<String> = ArrayList()

    /**
     * Assigns a MotorName to the Motor, and adds it to the HashMap.
     * @param motorName Name of the Motor
     */
    fun addMotor(motorName: String, isReversed: Boolean) {
        try {
            val motor: DcMotor = hardwareMap.get(DcMotor::class.java, motorName)
            motors[motorName] = motor
            if (isReversed) {
                reversedMotors.add(motorName);
            }
        } catch (e: IllegalArgumentException) {
            if (!warnedMotors.contains(motorName)) {
                telemetry.addLine("Warning: The motor '$motorName' was not found! The motor will not be operating, and may cause problems with the OpCode.")
                warnedMotors.add(motorName)
            }
        }
    }

    /**
     * Get Motor Name
     * @param motorName Name of the Motor
     * @return name of the motor
     */
    fun getMotor(motorName: String): DcMotor? {
        return motors[motorName]
    }

    /**
     * Sets the power of the motor
     * @param motorName Name of the Motor
     * @param power Power of the Motor
     */
    fun setPower(motorName: String, power: Double) {
        var convertedPower: Double = power;
        if (reversedMotors.contains(motorName)){
            convertedPower = -power;
        }
        val motor: DcMotor = getMotor(motorName) ?: return
        if (motor.power != convertedPower) {
            motor.power = convertedPower
        }
    }

    /**
     * Gets the power of the motor
     * @param motorName Name of the Motor
     * @return Power of the motor
     */
    fun getPower(motorName: String): Double {
        val motor: DcMotor = getMotor(motorName) ?: return 0.0
        if (reversedMotors.contains(motorName)) {
            return -motor.power;
        } else {
            return motor.power;
        }
    }

    /**
     * Removes the motor and sets its power to zero.
     * @param motorName Name of the Motor
     */
    fun removeMotor(motorName: String) {
        setPower(motorName, 0.0)
        motors.remove(motorName)
    }

}