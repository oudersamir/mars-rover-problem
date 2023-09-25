package rover;
/**
 * Represents a position on the plateau with x and y coordinates and a direction.
 */
public class Position {
    private int x;
    private int y;
    private Direction direction;

    /**
     * Constructs a new Position object with the specified coordinates and direction.
     *
     * @param x         The x-coordinate.
     * @param y         The y-coordinate.
     * @param direction The direction (N, E, S, or W).
     */
    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * Gets the x-coordinate of the position.
     *
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the position.
     *
     * @param x The new x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the position.
     *
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the position.
     *
     * @param y The new y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the direction of the position.
     *
     * @return The direction (N, E, S, or W).
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Sets the direction of the position.
     *
     * @param direction The new direction (N, E, S, or W).
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Returns a new Position object representing the position after turning right.
     *
     * @return The new Position object.
     */
    public Position toRight() {
        return new Position(x, y, direction.right());
    }

    /**
     * Returns a new Position object representing the position after turning left.
     *
     * @return The new Position object.
     */
    public Position toLeft() {
        return new Position(x, y, direction.left());
    }

    /**
     * Returns a new Position object representing the position after moving one unit
     * in the current direction.
     *
     * @return The new Position object.
     */
    public Position move() {
        int newX = this.x;
        int newY = this.y;
        switch (direction.toString()) {
            case "N":
                return new Position(newX, ++newY, direction);
            case "E":
                return new Position(++newX, newY, direction);
            case "S":
                return new Position(newX, --newY, direction);
            case "W":
                return new Position(--newX, newY, direction);
            default:
                throw new IllegalStateException("Unknown value");

        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction.toString();
    }
}
