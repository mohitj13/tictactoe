package game.controller;

import game.player.Player;

class Response {

    private Player player;
    private boolean winMove;
    private boolean gameDrawn;

    Response(Player player, boolean winMove, boolean gameDrawn) {
        this.player = player;
        this.winMove = winMove;
        this.gameDrawn = gameDrawn;
    }

    Player getPlayer() {
        return player;
    }

    boolean isWinMove() {
        return winMove;
    }

    boolean isGameDrawn() {
        return gameDrawn;
    }
}
