package game;

import game.data.Move;
import game.player.Player;

public class TicTacToeRenderer {

    private static final String ln = System.getProperty("line.separator");

    public void displayBoard(Move[][] board){
        // print board
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                builder.append(board[i][j]);
                if (j == board.length - 1) continue;
                builder.append("|");
            }
            if (i == board.length - 1) continue;
            builder.append(ln).append("-----").append(ln);
        }

        builder.append(ln).append(ln);
        System.out.println(builder.toString());

    }

    public void displayWinner(Player player) {
        System.out.println(player + " won the game!");
    }

    public void displayGameDrawn() {
        System.out.println("Game is drawn!");
    }
}
