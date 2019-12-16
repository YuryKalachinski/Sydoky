package sydoky;

class Cell {
    private int x, y;
    private char value;

    Cell(int y, int x) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    char getValue() {
        return value;
    }

    void setValue(char value) {
        this.value = value;
    }
}
