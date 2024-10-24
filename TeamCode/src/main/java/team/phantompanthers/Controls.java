package team.phantompanthers;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * <h1>Controls Value Collector Documentation</h1>
 * <p>Control Value Collector is a class that returns each Gamepad button as a boolean or float collecting Input.</p>
 * @author konekowo
 * @author BeanZip
 */
public class Controls {

    /**
     * Returns a boolean based on if the control mapping is pressed.
     *
     * @param gamepad The gamepad to check
     * @param control The control to check
     * @return The returned value
     */
    public static boolean getBoolean(Gamepad gamepad, ControlMappings control) {
        switch (control) {
            case EXTEND_ARM:
                return gamepad.left_bumper;
            case RETRACT_ARM:
                return gamepad.right_bumper;
            case RAISE_ARM:
                return gamepad.right_stick_y > 0f;
            case LOWER_ARM:
                return gamepad.right_stick_y < 0f;
            default:
                return false;
        }
    }

    /**
     * Returns a float based on if the control mapping is active.
     *
     * @param gamepad The gamepad to check
     * @param control The control to check
     * @return The returned value
     */
    public static float getFloat(Gamepad gamepad, ControlMappings control) {
        switch (control) {
            case FORWARD:
                return gamepad.right_trigger;
            case BACKWARD:
                return gamepad.left_trigger;
            case LEFT:
                return Math.min(-gamepad.left_stick_x, 0f);
            case RIGHT:
                return Math.max(gamepad.left_stick_x, 0f);
            default:
                return 0f;
        }
    }
}
