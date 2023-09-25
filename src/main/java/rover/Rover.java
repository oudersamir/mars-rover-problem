package rover;

public class Rover {

    private Position position;

    public Rover(Position position) {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void executeCommand(String commands){
        commands.chars().mapToObj(c->(char)c).forEach(this::process);
    }

    private void process(char command){
        switch (command){
            case 'L':
                position=position.toLeft();
                break;
            case 'R':
                position=position.toRight();
                break;
            case 'M':
                position= position.move();
              break;
            default:
                throw new IllegalStateException("Unknown command");

        }

    }

    @Override
    public String toString() {
        return position.toString();
    }
}
