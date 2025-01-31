package team.phantompanthers;

import com.qualcomm.robotcore.hardware.Gamepad;

public enum ControlMappings {
    MOVEMENT_X("left_stick_x"),
    MOVEMENT_Y("left_stick_y"),
    TURN_LEFT("left_trigger"),
    TURN_RIGHT("right_trigger"),
    GRIP_CLAW("a"),
    RAISE_ARM("right_stick_y"),
    HORIZONTAL_ARM("right_stick_y");

    public final String fieldName;
    private final ICallback valueModifier;

    /**
     * Constructor of ControlMappings
     *
     * @param fieldName The field name of the Gamepad control to get.
     */

    ControlMappings(String fieldName) {
        this(fieldName, null);
    }

    /**
     * Constructor of ControlMappings
     *
     * @param fieldName     The field name of the Gamepad control to get.
     * @param valueModifier A callback function that modifies the value returned.
     */
    ControlMappings(String fieldName, ICallback valueModifier) {
        this.fieldName = fieldName;
        this.valueModifier = valueModifier;
    }

    /**
     * Get the float value of a control.
     *
     * @param gamepad The GamePad object.
     * @return The float value of the control.
     */
    public float getFloat(Gamepad gamepad) {
        float value;
        try {
            value = gamepad.getClass().getField(this.fieldName).getFloat(gamepad);
            if (this.valueModifier != null) value = (float) this.valueModifier.call(value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("The field '" + this.fieldName + "' is not a float or does not exit on the " + Gamepad.class.getName() + " class.");
        }
        return value;
    }

    /**
     * Get the boolean value of a control.
     *
     * @param gamepad The GamePad object.
     * @return The boolean value of the control.
     */
    public boolean getBoolean(Gamepad gamepad) {
        boolean value;
        try {
            value = gamepad.getClass().getField(this.fieldName).getBoolean(gamepad);
            if (this.valueModifier != null) value = (boolean) this.valueModifier.call(value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("The field '" + this.fieldName + "' is not a float or does not exit on the " + Gamepad.class.getName() + " class.");
        }
        return value;
    }
}
