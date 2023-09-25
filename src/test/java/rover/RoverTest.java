package rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {
    @Test
    void testExecuteCommand() {
        // Créer une position initiale pour le rover
        Position initialPosition = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(initialPosition);

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
        Rover rover = new Rover(initialPosition);

        // Exécuter une commande invalide
        assertThrows(IllegalStateException.class, () -> {
            rover.executeCommand("LMX");
        });
    }
}
