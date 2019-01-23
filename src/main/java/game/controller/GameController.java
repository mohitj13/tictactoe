package game.controller;

import game.TicTacToeRenderer;
import game.player.Player;
import game.board.TicTacToeBoard;

public class GameController {

    private Player player1;
    private Player player2;
    private TicTacToeBoard ticTacToeBoard;
    private TicTacToeRenderer ticTacToeRenderer;

    private Player nextTurn;

    public GameController(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.ticTacToeBoard = new TicTacToeBoard();
        this.ticTacToeRenderer = new TicTacToeRenderer();
    }

    public void play() {
        ticTacToeRenderer.displayBoard(ticTacToeBoard.getBoard());
        Response response;
        do {
            response = makeMove();
        } while (!response.isGameDrawn() && !response.isWinMove());

        if (response.isWinMove()) {
            // display the winner
            ticTacToeRenderer.displayWinner(response.getPlayer());
        } else if (response.isGameDrawn()) {
            // display the game is drawn and no one is a winner
            ticTacToeRenderer.displayGameDrawn();
        }
    }

    private Response makeMove() {
        Player player = whoseTurn();
        player.makeMove();
        ticTacToeBoard.saveMove(player.getLocation(), player.getMove());
        ticTacToeRenderer.displayBoard(ticTacToeBoard.getBoard());
        return new Response(player, ticTacToeBoard.isWinMove(player.getLocation(), player.getMove()),
                ticTacToeBoard.isGameDrawn());
    }

    private Player whoseTurn(){
        Player currentPlayer;
        if (nextTurn == null){
            currentPlayer = player1;
            nextTurn = player2;
        } else {
            currentPlayer = nextTurn.equals(player1) ? player1 : player2;
            nextTurn = currentPlayer.equals(player1) ? player2 : player1;;
        }
        return currentPlayer;
    }

}
