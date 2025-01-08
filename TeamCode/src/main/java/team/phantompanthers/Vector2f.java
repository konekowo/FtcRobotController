package team.phantompanthers;

import androidx.annotation.Nullable;

/**
 * A 2D Float Vector class.
 */
public class Vector2f {
    private float x;
    private float y;

    /**
     * The constructor for a Vector2f.
     *
     * @param x The x value for this 2D Vector.
     * @param y The y value for this 2D Vector.
     */
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x value from this 2D Vector.
     *
     * @return The x value from this 2D Vector as a float.
     */
    public float getX() {
        return x;
    }

    /**
     * Set the x value for this 2D Vector.
     *
     * @param x The x value to set in this 2D Vector.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get the y value from this 2D Vector.
     *
     * @return The y value from this 2D Vector as a float.
     */
    public float getY() {
        return y;
    }

    /**
     * Set the y value for this 2D Vector.
     *
     * @param y The y value to set in this 2D Vector.
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Calculate the distance between this 2D Vector and another 2D Vector
     *
     * @param otherVector The other 2D Vector.
     * @return The distance between this 2D Vector and the other 2D Vector.
     */
    public float distance(Vector2f otherVector) {
        return (float) Math.sqrt(Math.pow(otherVector.getX() - x, 2)
                + Math.pow(otherVector.getY() - y, 2));
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj != null) {
            if (obj instanceof Vector2f otherVector) {
                return otherVector.getX() == x && otherVector.getY() == y;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
