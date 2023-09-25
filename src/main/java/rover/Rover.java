package rover;

/**
 * Represents a rover on the plateau with a specific position.
 */
public class Rover {

    private Position position;
    private final Plateau plateau;

    /**
     * Constructs a new Rover object with the specified plateau and position.
     *
     * @param plateau        The plateau on which the rover moves.
     * @param position       The initial position of the rover.
     */
    public Rover(Plateau plateau, Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    /**
     * Gets the current position of the rover.
     *
     * @return The current position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the current position of the rover.
     *
     * @param position The new position.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Executes a series of commands to control the rover's movement.
     *
     * @param commands The string containing the commands (L, R, M).
     */
    public void executeCommand(String commands) {
        commands.chars().mapToObj(c -> (char) c).forEach(this::process);
    }

    /**
     * Processes an individual command character.
     *
     * @param command The command character (L, R, M).
     */
    private void process(char command) {
        switch (command) {
            case 'L':
                position = position.toLeft();
                break;
            case 'R':
                position = position.toRight();
                break;
            case 'M':
                move();
                break;
            default:
                throw new IllegalStateException("Unknown command");

        }

    }

    /**
     * Moves the rover one unit in its current direction if it remains within the plateau.
     */
    private void move() {
        if (isInPlateau(position.move())) {
            position = position.move();
        }
    }

    /**
     * Checks if the rover is within the plateau boundaries.
     *
     * @return True if the rover is within the plateau, false otherwise.
     */
    public boolean isInPlateau() {
        return isInPlateau(this.position);

    }

    /**
     * Checks if a given position is within the plateau boundaries.
     *
     * @param position The position to check.
     * @return True if the position is within the plateau, false otherwise.
     */
    public boolean isInPlateau(Position position) {
        boolean isWithIn = this.plateau.getX() >= position.getX() && this.plateau.getY() >= position.getY();
        boolean isOutside = position.getX() >= 0 && position.getY() >= 0;
        return isWithIn && isOutside;

    }

    @Override
    public String toString() {
        return position.toString();
    }
}
