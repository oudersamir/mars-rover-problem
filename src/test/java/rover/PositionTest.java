package rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void testToRight() {
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        Position newPosition = initialPosition.toRight();
        assertEquals(Direction.EAST, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    void testToLeft() {
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        Position newPosition = initialPosition.toLeft();
        assertEquals(Direction.WEST, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    void testMoveNorth() {
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        Position newPosition = initialPosition.move();
        assertEquals(Direction.NORTH, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(2, newPosition.getY());
    }

    @Test
    void testMoveEast() {
        Position initialPosition = new Position(1, 1, Direction.EAST);
        Position newPosition = initialPosition.move();
        assertEquals(Direction.EAST, newPosition.getDirection());
        assertEquals(2, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }

    @Test
    void testMoveSouth() {
        Position initialPosition = new Position(1, 1, Direction.SOUTH);
        Position newPosition = initialPosition.move();
        assertEquals(Direction.SOUTH, newPosition.getDirection());
        assertEquals(1, newPosition.getX());
        assertEquals(0, newPosition.getY());
    }

    @Test
    void testMoveWest() {
        Position initialPosition = new Position(1, 1, Direction.WEST);
        Position newPosition = initialPosition.move();
        assertEquals(Direction.WEST, newPosition.getDirection());
        assertEquals(0, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }
}
