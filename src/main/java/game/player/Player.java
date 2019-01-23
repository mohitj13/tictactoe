package game.player;

import game.data.Location;
import game.data.Move;

public class Player {

    private final Move move;
    private UserInput userInput;
    private Location location;

    public Player(Move move, UserInput userInput) {
        this.move = move;
        this.userInput = userInput;
    }

    public Move getMove(){
        return move;
    }

    public Location getLocation() {
        return location;
    }

    public void makeMove() {
        // Ask user input to get the next location for this user
        location = Location.convertNumberToLocation(userInput.getUserInput(this));
    }

    @Override
    public String toString() {
        return "Player{" +
                "move=" + move +
                '}';
    }
}
