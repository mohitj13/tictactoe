package game.board;

import game.data.Location;
import game.data.Move;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TicTacToeBoard {

    private final Move[][] board;
    private final int boardSize;

    public TicTacToeBoard() {
        this(3);
    }

    private TicTacToeBoard(int boardSize) {
        if (boardSize <= 1) {
            throw new IllegalArgumentException("A board game must be more than 1 row and column!");
        }
        this.board = new Move[boardSize][boardSize];
        this.boardSize = boardSize;
        // initialise board
        IntStream.range(0, board.length).forEach(i ->
                IntStream.range(0, board[i].length).forEach(j ->
                        board[i][j] = Move.NONE
                )
        );
    }

    public Move[][] getBoard() {
        return board;
    }

    public void saveMove(Location location, Move move) {
        if (board[location.getRow()][location.getColumn()] != Move.NONE) {
            throw new IllegalArgumentException("Location is already used!");
        }
        board[location.getRow()][location.getColumn()] = move;
    }

    /**
     * Is a Win move when TicTacToe winning condition met
     * @param location Location
     * @param move Move
     * @return true when a win move otherwise false
     */
    public boolean isWinMove(Location location, Move move) {
        boolean winCondition = true;

        // check row condition
        for (int x=0; x < boardSize; x++) {
            if (board[location.getRow()][x] != move) {
                winCondition = false;
            }
        }
        if (winCondition) {
            return true;
        }

        winCondition = true;
        // check column condition
        for (int x=0; x < boardSize; x++) {
            if (board[x][location.getColumn()] != move) {
                winCondition = false;
            }
        }
        if (winCondition) {
            return true;
        }

        winCondition = true;
        // check diagonal
        for (int x=0; x < boardSize; x++) {
            if (board[x][x] != move) {
                winCondition = false;
            }
        }
        if (winCondition) {
            return true;
        }

        winCondition = true;
        for (int x=0; x < boardSize; x++) {
            if (board[x][(boardSize-1)-x] != move) {
                winCondition = false;
            }
        }

        return winCondition;
    }

    public boolean isGameDrawn() {
        // check the board if game is drawn or not
        return Arrays.stream(board)
                .flatMap(Arrays::stream)
                .noneMatch(move -> move == Move.NONE);
    }
}
