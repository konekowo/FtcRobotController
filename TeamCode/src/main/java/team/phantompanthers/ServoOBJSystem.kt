package team.phantompanthers

import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.robotcore.external.navigation.Position

/**
 * This Class is a more easier way of adding mini-motors to the robot.
 * @param hardwareMap Hardware Map of the Motor
 * @param telemetry Telemetry of the robot
 */
class ServoOBJSystem(private val hardwareMap: HardwareMap, private val telemetry: Telemetry) {
    private val miniMotors: MutableMap<String, Servo> = HashMap()
    private val warnedMotors: MutableList<String> = ArrayList()
    private val reversedMotors: MutableList<String> = ArrayList()
    private val speeds: MutableMap<String, Double> = HashMap()

    fun addMotor(motorName: String) {
        try {
            val miniMotor: Servo = hardwareMap.get(Servo::class.java, motorName)
            miniMotors[motorName] = miniMotor
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
    fun getMotor(motorName: String): Servo? {
        return miniMotors[motorName]
    }

    /**
     * Sets the power of the motor
     * @param motorName Name of the Motor
     * @param power Power of the Motor
     */
    fun setPosition(motorName: String, position: Double) {
        var convertedPosition: Double = position
        if (reversedMotors.contains(motorName)) {
            convertedPosition = -position
        }
        if (getPosition(motorName) != convertedPosition) {
            speeds[motorName] = convertedPosition
        }
    }

    /**
     * Gets the power of the motor
     * @param motorName Name of the Motor
     * @return Power of the motor
     */
    fun getPosition(motorName: String): Double {
        val motor: Servo = getMotor(motorName) ?: return 0.0
        return if (speeds[motorName] == null) {
            if (reversedMotors.contains(motorName)) {
                -motor.position
            } else {
                motor.position
            }
        } else {
            speeds[motorName]!!
        }
    }

    /**
     * Removes the motor and sets its power to zero.
     * @param motorName Name of the Motor
     */
    fun removeMotor(motorName: String) {
        setPosition(motorName, 0.0)
        miniMotors.remove(motorName)
    }

    /**
     * Updates the motors that were changed with the changed speeds.
     */
    fun updateMotors() {
        for (speed in speeds) {
            val motorName: String = speed.key
            val power: Double = speed.value
            val motor: Servo = getMotor(motorName) ?: continue
            if (motor.position != power) {
                motor.position = power
            }
        }
        speeds.clear()
    }
}