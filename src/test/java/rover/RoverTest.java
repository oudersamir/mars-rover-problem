package rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Plateau plateau;
    @BeforeEach
    void init(){
        plateau= new Plateau(5,5);
    }
    @Test
    void testExecuteCommand() {
        // Créer une position initiale pour le rover
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(plateau,initialPosition);

        // Exécuter une série de commandes
        rover.executeCommand("LMLMLMLMM");

        // Vérifier si la position finale est correcte
        Position finalPosition = rover.getPosition();
        assertEquals(Direction.NORTH, finalPosition.getDirection());
        assertEquals(1, finalPosition.getX());
        assertEquals(2, finalPosition.getY());
    }

    @Test
    void testExecuteInvalidCommand() {
        // Créer une position initiale pour le rover
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(plateau, initialPosition);

        // Exécuter une commande invalide
        assertThrows(IllegalStateException.class, () ->
                rover.executeCommand("LMX"));
    }
    @Test
    void testIsInPlateau() {
        Plateau plateau = new Plateau(5, 5);
        Position positionInside = new Position(3, 3, Direction.NORTH);
        Position positionOutside = new Position(6, 6, Direction.NORTH);
        Rover roverInside = new Rover(plateau, positionInside);
        Rover roverOutside = new Rover(plateau, positionOutside);

        assertTrue(roverInside.isInPlateau());
        assertFalse(roverOutside.isInPlateau());
    }
}
