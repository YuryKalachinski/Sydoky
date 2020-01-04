package sydoky;

abstract class Field {
    private static final int SIZE_FIELD = 9;
    private static final int SIZE_CELLS_BLOCK = 3;
    private boolean isAllNumbersAreFilled = false;
    private Cell[][] cells = new Cell[SIZE_FIELD][SIZE_FIELD];
    private CellsStack stackCells = new CellsStack();

    Field() {
        initCells();
        initStaticValuesInField(cells);
    }

    abstract void initStaticValuesInField(Cell[][] cells);

    void startSolution() {
        showField();
        solution();
        System.out.println();
        showField();
    }

    private void solution() {
        stackCells.push(findNextEmptyCell(cells[0][0]));
        while (!isAllNumbersAreFilled) {
            if (checkCell(stackCells.peek())) {
                stackCells.push(findNextEmptyCell(stackCells.peek()));
            } else {
                selectNextCellValue();
            }
        }
    }

    private void selectNextCellValue() {
        if (stackCells.peek().getValue() < '9') {
            stackCells.peek().setValue((char) (stackCells.peek().getValue() + 1));
        } else {
            stackCells.peek().setValue((char) 0);
            stackCells.pop();
            selectNextCellValue();
        }
    }

    private boolean checkCell(Cell cell) {
        return (checkCellByHorizontal(cell) && checkCellByVertical(cell) && checkCellBySquare(cell));
    }

    private boolean checkCellByHorizontal(Cell cell) {
        for (int i = 0; i < SIZE_FIELD; i++) {
            if (cell.getValue() == cells[cell.getY()][i].getValue() && cell.getX()!=i) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCellByVertical(Cell cell) {
        for (int i = 0; i < SIZE_FIELD; i++) {
            if (cell.getValue() == cells[i][cell.getX()].getValue() && cell.getY()!=i) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCellBySquare(Cell cell) {
        int x = cell.getX() / SIZE_CELLS_BLOCK;
        int y = cell.getY() / SIZE_CELLS_BLOCK;
        for (int i = 0; i < SIZE_CELLS_BLOCK; i++) {
            for (int j = 0; j < SIZE_CELLS_BLOCK; j++) {
                if (cell.getValue() == cells[3 * y + i][3 * x + j].getValue() && cell != cells[3 * y + i][3 * x + j]){
                    return false;
                }
            }
        }
        return true;
    }

    private Cell findNextEmptyCell(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        if (cell.getValue() == 0) {
            cell.setValue('1');
            return cell;
        }
        if (x == SIZE_FIELD - 1 && y == SIZE_FIELD - 1) {
            isAllNumbersAreFilled = true;
            return null;
        }
        if (x == SIZE_FIELD - 1) {
            y++;
            x = 0;
        } else {
            x++;
        }
        return findNextEmptyCell(cells[y][x]);
    }

    private void initCells() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    private void showField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE_FIELD; j++) {
                System.out.print(cells[i][j].getValue() + " | ");
            }
            System.out.println();
        }
    }
}
