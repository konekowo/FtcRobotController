package team.phantompanthers;

import com.qualcomm.robotcore.hardware.Gamepad;

public enum ControlMappings {
    FORWARD("right_trigger"),
    BACKWARD("left_trigger"),
    LEFT("left_stick_x", value -> Math.min(-((float) value), 0f)),
    RIGHT("left_stick_x", value -> Math.max((float) value, 0f)),
    EXTEND_ARM("right_bumper"),
    RETRACT_ARM("left_bumper"),
    RAISE_ARM("right_stick_y", value -> Math.max((float) value, 0f)),
    LOWER_ARM("right_stick_y", value -> Math.min(-((float) value), 0f));

    public final String fieldName;
    private final ICallback valueModifier;

    /**
     * Constructor of ControlMappings
     *
     * @param fieldName The fieldname of the Gamepad control to get.
     */

    ControlMappings(String fieldName) {
        this(fieldName, null);
    }

    /**
     * Constructor of ControlMappings
     *
     * @param fieldName     The fieldname of the Gamepad control to get.
     * @param valueModifier A callback function that modifies the value returned.
     */
    ControlMappings(String fieldName, ICallback valueModifier) {
        this.fieldName = fieldName;
        this.valueModifier = valueModifier;
    }

    /**
     * Get the value of a control.
     *
     * @param <T>     The expected return type.
     * @param type    The expected return type.
     * @param gamepad The GamePad object.
     * @return The value of the control.
     */
    public <T> T get(Class<T> type, Gamepad gamepad) {
        T value;
        try {
            if (gamepad.getClass().getField(this.fieldName).getType() == type) {
                value = type.cast(gamepad.getClass().getField(this.fieldName).get(gamepad));
                if (this.valueModifier != null) value = type.cast(this.valueModifier.call(value));
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException | ClassCastException e) {
            throw new RuntimeException("The field '" + this.fieldName + "' is not a '" + type.getName() + "' or does not exit on the " + Gamepad.class.getName() + " class.");
        }
        return value;
    }
}
