package team.phantompanthers.part_specific

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
    private val speeds: MutableMap<String, Double> = HashMap()

    /**
     * Assigns a MotorName to the Motor, and adds it to the HashMap.
     * @param motorName Name of the Motor
     */
    fun addMotor(motorName: String, isReversed: Boolean) {
        try {
            val motor: DcMotor = hardwareMap.get(DcMotor::class.java, motorName)
            motors[motorName] = motor
            if (isReversed) {
                reversedMotors.add(motorName)
            }
        } catch (e: IllegalArgumentException) {
            if (!warnedMotors.contains(motorName)) {
                telemetry.addLine("Warning: The motor '$motorName' was not found! The motor will not be operating, and may cause problems with the OpCode.")
                warnedMotors.add(motorName)
            }
        }
    }

    /**
     * Get a Motor object.
     * @param motorName The name of the motor.
     * @return The Motor object.
     */
    fun getMotor(motorName: String): DcMotor? {
        return motors[motorName]
    }

    /**
     * Get all Motor objects registered to this MotorSystem.
     * @return The Motor objects registered to this MotorSystem in a List.
     */
    fun getMotors(): List<DcMotor> {
        return motors.values.toList()
    }

    /**
     * Sets the power of a motor.
     * @param motorName The name of the motor.
     * @param power The power to set the motor to.
     */
    fun setPower(motorName: String, power: Double) {
        var convertedPower: Double = power
        if (reversedMotors.contains(motorName)) {
            convertedPower = -power
        }
        if (getPower(motorName) != convertedPower) {
            speeds[motorName] = convertedPower
        }
    }

    /**
     * Gets the power of a motor.
     * @param motorName The name of the motor.
     * @return The power of the motor
     */
    fun getPower(motorName: String): Double {
        val motor: DcMotor = getMotor(motorName) ?: return 0.0
        return if (speeds[motorName] == null) {
            if (reversedMotors.contains(motorName)) {
                -motor.power
            } else {
                motor.power
            }
        } else {
            speeds[motorName]!!
        }
    }

    /**
     * Removes a motor and sets its power to zero.
     * @param motorName The name of the Motor.
     */
    fun removeMotor(motorName: String) {
        setPower(motorName, 0.0)
        motors.remove(motorName)
    }

    /**
     * Updates motors that were changed with the changed speeds.
     */
    fun updateMotors() {
        for (speed in speeds) {
            val motorName: String = speed.key
            val power: Double = speed.value
            val motor: DcMotor = getMotor(motorName) ?: continue
            if (motor.power != power) {
                motor.power = power
            }
        }
        speeds.clear()
    }

}