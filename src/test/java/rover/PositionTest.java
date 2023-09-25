package rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Position class.
 */
class PositionTest {

    @Test
    void testToRight() {
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        // Turn right and check the new position
        Position newPosition = initialPosition.toRight();
        assertEquals(Direction.EAST, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    void testToLeft() {
        Position initialPosition = new Position(1, 1, Direction.NORTH);

        // Turn left and check the new position
        Position newPosition = initialPosition.toLeft();
        assertEquals(Direction.WEST, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    void testMoveNorth() {
        Position initialPosition = new Position(1, 1, Direction.NORTH);

        // Move to North and check the new position
        Position newPosition = initialPosition.move();
        assertEquals(Direction.NORTH, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(2, newPosition.getY());
    }

    @Test
    void testMoveEast() {
        Position initialPosition = new Position(1, 1, Direction.EAST);

        // Move to East and check the new position
        Position newPosition = initialPosition.move();
        assertEquals(Direction.EAST, newPosition.getDirection());
        assertEquals(2, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    void testMoveSouth() {
        Position initialPosition = new Position(1, 1, Direction.SOUTH);

        // Move to South and check the new position
        Position newPosition = initialPosition.move();
        assertEquals(Direction.SOUTH, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(0, newPosition.getY());
    }

    @Test
    void testMoveWest() {
        Position initialPosition = new Position(1, 1, Direction.WEST);

        // Move to West and check the new position
        Position newPosition = initialPosition.move();
        assertEquals(Direction.WEST, newPosition.getDirection());
        assertEquals(0, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }
}
