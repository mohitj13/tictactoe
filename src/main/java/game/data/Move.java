package game.data;

public enum Move {
    NONE("_"),
    O("O"),
    X("X");

    private String code;

    Move(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
