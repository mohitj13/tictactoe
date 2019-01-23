package game.player;

import java.util.Scanner;

public class UserInput implements AutoCloseable {

    private Scanner input = new Scanner(System.in);

    private boolean verify(int playerInput){
        return 0 < playerInput && playerInput <= 9;
    }

    int getUserInput(Player player) {
        System.out.println(player + " turn : ");
        return readInput();
    }

    private int readInput() {
        int playerInput;
        try {
            playerInput = input.nextInt();
            // verify input otherwise ask for input again
            if (!verify(playerInput)) {
                playerInput = 0;
            }
        } catch (NumberFormatException e) {
            playerInput = 0;
        }

        if (playerInput == 0) {
            playerInput = readInput();
        }

        return playerInput;
    }

    public void close(){
        input.close();
    }
}
