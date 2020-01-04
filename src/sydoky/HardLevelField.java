package sydoky;

class HardLevelField extends Field{

    @Override
    void initStaticValuesInField(Cell[][] cells) {
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
}
