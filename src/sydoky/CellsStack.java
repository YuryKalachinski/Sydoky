package sydoky;

public class CellsStack {
    private Cell[] cellsStack;
    int top;

    CellsStack() {
        cellsStack = new Cell[81];
        top = -1;

    }

    void push(Cell cell) {
        if (cell == null || top == cellsStack.length - 1) {
            return;
        }
        cellsStack[++top] = cell;
    }

    Cell pop() {
        if (top < 0) {
            return null;
        }
        return cellsStack[top--];
    }

    Cell peek() {
        if (top < 0) {
            return null;
        }
        return cellsStack[top];
    }
}
