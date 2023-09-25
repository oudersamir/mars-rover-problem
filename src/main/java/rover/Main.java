package rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("input.text file is mandatory !!");
            System.exit(1);
        }


        String inputFileName = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            String[] plateauSize = reader.readLine().split(" ");
            int maxX = Integer.parseInt(plateauSize[0]);
            int maxY = Integer.parseInt(plateauSize[1]);

            Plateau plateau = new Plateau(maxX, maxY);

            while ((line = reader.readLine()) != null) {
                String[] roverInfo = line.split(" ");

                int x = Integer.parseInt(roverInfo[0]);
                int y = Integer.parseInt(roverInfo[1]);

                Direction direction = Direction.fromCode(roverInfo[2]);

                Rover rover = new Rover(plateau, new Position(x, y, direction));
                String instructions = reader.readLine();

                if (rover.isInPlateau()) {
                    rover.executeCommand(instructions);
                    System.out.println(rover.getPosition());
                }

            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            System.exit(1);
        }
    }
}
