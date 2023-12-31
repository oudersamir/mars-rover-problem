package rover;

public enum Direction {
    NORTH("N") {
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return WEST;
        }
    },
    EAST("E") {
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }
    },
    SOUTH("S") {
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }
    },
    WEST("W") {
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }
    };
    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public abstract Direction right();

    public abstract Direction left();
    public static Direction fromCode(String code) {
        for (Direction direction : Direction.values()) {
            if (direction.direction.equals(code)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

    @Override
    public String toString() {
        return direction;
    }
}
