package team.phantompanthers;

/**
 * <h1>ICallback Documentation</h1>
 * Call's a Value and returns a Value
 */
public interface ICallback {
    /**
     * Calls this function with the specified value as its argument and returns the result.
     *
     * @param value The argument to pass to the function.
     * @return The result of the function call.
     */
    Object call(Object value);
}
