package game.data;

public class Location {

    private int row;
    private int column;
// comment
    private Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public static Location convertNumberToLocation(int number) {
        return new Location((number-1)/3 , (number-1)%3);
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
