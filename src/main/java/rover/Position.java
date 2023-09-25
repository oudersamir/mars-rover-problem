package rover;

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position() {
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position toRight() {
        return new Position(x, y, direction.right());
    }

    public Position toLeft() {
        return new Position(x, y, direction.left());
    }

    public Position move() {
        switch (direction.toString()) {
            case "N":
                return new Position(x, ++y , direction);
            case "E":
                return new Position(++x , y, direction);
            case "S":
                return new Position(x, --y , direction);
            case "W":
                return new Position(--x, y, direction);
            default:
                throw new IllegalStateException("Unknown value");

        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
