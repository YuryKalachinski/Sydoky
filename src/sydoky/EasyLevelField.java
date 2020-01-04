package sydoky;

class EasyLevelField extends Field{

    @Override
    void initStaticValuesInField(Cell[][] cells) {
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
}
