package sydoky;

import java.util.Stack;

class Field {
    private static final int SIZE_FIELD = 9;
    private static final int SIZE_CELLS_BLOCK = 3;
    private boolean isAllNumbersAreFilled = false;
    private Cell[][] cells;
    private Stack<Cell> stackCells;

    Field() {
        initCells();
        initStaticValuesInFieldEazy();
//        initStaticValuesInFieldHard();
        stackCells = new Stack<>();
    }

    void startSolution() {
        stackCells.push(findNextEmptyCell(cells[0][0]));
        while (!isAllNumbersAreFilled) {
            if (checkCell(stackCells.peek())) {
                stackCells.push(findNextEmptyCell(stackCells.peek()));
            } else {
                selectNextCellValue(stackCells.peek());
            }
        }
    }

    private void selectNextCellValue(Cell cell) {
        if (stackCells.peek().getValue() < '9') {
            stackCells.peek().setValue((char) (stackCells.peek().getValue() + 1));
        } else {
            stackCells.peek().setValue((char) 0);
            stackCells.pop();
            selectNextCellValue(stackCells.peek());
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

    private void initStaticValuesInFieldHard() {
        cells[0][3].setValue('2');
        cells[0][4].setValue('4');
        cells[0][5].setValue('7');
        cells[1][3].setValue('1');
        cells[1][7].setValue('7');
        cells[2][0].setValue('1');
        cells[2][1].setValue('9');
        cells[2][2].setValue('7');
        cells[2][5].setValue('3');
        cells[2][6].setValue('5');
        cells[3][5].setValue('1');
        cells[3][8].setValue('3');
        cells[4][1].setValue('5');
        cells[4][7].setValue('6');
        cells[5][6].setValue('9');
        cells[5][8].setValue('8');
        cells[6][0].setValue('6');
        cells[6][2].setValue('5');
        cells[6][8].setValue('4');
        cells[7][1].setValue('3');
        cells[7][3].setValue('9');
        cells[7][5].setValue('8');
        cells[8][2].setValue('9');
        cells[8][4].setValue('7');
        cells[8][6].setValue('3');
    }

    private void initStaticValuesInFieldEazy() {
        cells[0][1].setValue('6');
        cells[0][2].setValue('2');
        cells[0][3].setValue('5');
        cells[0][5].setValue('4');
        cells[0][7].setValue('7');
        cells[1][0].setValue('3');
        cells[1][3].setValue('8');
        cells[1][5].setValue('9');
        cells[1][6].setValue('5');
        cells[1][8].setValue('1');
        cells[2][0].setValue('1');
        cells[2][2].setValue('5');
        cells[2][4].setValue('6');
        cells[2][6].setValue('4');
        cells[2][8].setValue('9');
        cells[3][0].setValue('5');
        cells[3][1].setValue('3');
        cells[3][2].setValue('1');
        cells[3][3].setValue('2');
        cells[3][6].setValue('9');
        cells[4][1].setValue('2');
        cells[4][2].setValue('7');
        cells[4][6].setValue('6');
        cells[5][2].setValue('9');
        cells[5][3].setValue('1');
        cells[5][4].setValue('3');
        cells[5][7].setValue('5');
        cells[5][8].setValue('7');
        cells[6][3].setValue('6');
        cells[6][4].setValue('9');
        cells[6][5].setValue('3');
        cells[7][0].setValue('7');
        cells[7][4].setValue('8');
        cells[7][7].setValue('9');
        cells[7][8].setValue('6');
        cells[8][0].setValue('4');
        cells[8][6].setValue('8');
        cells[8][7].setValue('3');
    }

    private void initCells() {
        cells = new Cell[SIZE_FIELD][SIZE_FIELD];
        for (int i = 0; i < SIZE_FIELD; i++) {
            for (int j = 0; j < SIZE_FIELD; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    void showField() {
        for (int i = 0; i < SIZE_FIELD; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE_FIELD; j++) {
                System.out.print(cells[i][j].getValue() + " | ");
            }
            System.out.println();
        }
    }
}
