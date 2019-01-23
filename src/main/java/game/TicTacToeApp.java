package game;

import game.player.Player;
import game.controller.GameController;
import game.data.Move;
import game.player.UserInput;

public class TicTacToeApp {
    public static void main(String[] args) {

        try (UserInput userInput = new UserInput()) {
            // create two players
            Player player1 = new Player(Move.O, userInput);
            Player player2 = new Player(Move.X, userInput);
            // create the game controller
            GameController controller = new GameController(player1, player2);
            // Play the game
            controller.play();
        }
    }
}
