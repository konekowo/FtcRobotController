package team.phantompanthers.part_specific

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

/**
 * This Class is a more easier way of adding mini-motors to the robot.
 * @param hardwareMap Hardware Map of the Motor
 * @param telemetry Telemetry of the robot
 */
class ServoSystem(private val hardwareMap: HardwareMap, private val telemetry: Telemetry) {
    private val servos: MutableMap<String, Servo> = HashMap()
    private val warnedServos: MutableList<String> = ArrayList()
    private val positions: MutableMap<String, Double> = HashMap()

    fun addMotor(servoName: String) {
        try {
            val servo: Servo = hardwareMap.get(Servo::class.java, servoName)
            servos[servoName] = servo
        } catch (e: IllegalArgumentException) {
            if (!warnedServos.contains(servoName)) {
                telemetry.addLine("Warning: The Servo '$servoName' was not found! The motor will not be operating, and may cause problems with the OpCode.")
                warnedServos.add(servoName)
            }
        }
    }

    /**
     * Get a Servo object
     * @param servoName Name of the Servo
     * @return name of the servo
     */
    fun getServo(servoName: String): Servo? {
        return servos[servoName]
    }

    /**
     * Get all Servo objects registered to this ServoSystem.
     * @return The Servo objects registered to this ServoSystem in a List.
     */
    fun getServos(): List<Servo> {
        return servos.values.toList()
    }

    /**
     * Sets the position of the servo
     * @param servoName Name of the servo
     * @param position Position that the servo should be set to (0.0 to 1.0)
     */
    fun setPosition(servoName: String, position: Double) {
        if (getPosition(servoName) != position) {
            positions[servoName] = position
        }
    }

    /**
     * Gets the position of the servo
     * @param motorName Name of the servo
     * @return The current position of the servo
     */
    fun getPosition(motorName: String): Double {
        val motor: Servo = getServo(motorName) ?: return 0.0
        return if (positions[motorName] == null) {
            motor.position
        } else {
            positions[motorName]!!
        }
    }

    /**
     * Removes the servo and sets its position to zero.
     * @param servoName Name of the servo
     */
    fun removeMotor(servoName: String) {
        setPosition(servoName, 0.0)
        servos.remove(servoName)
    }

    /**
     * Updates servos that were changed with the changed speeds.
     */
    fun updateServos() {
        for (position in positions) {
            val servoName: String = position.key
            val position: Double = position.value
            val servo: Servo = getServo(servoName) ?: continue
            if (servo.position != position) {
                servo.position = position
            }
        }
        positions.clear()
    }
}