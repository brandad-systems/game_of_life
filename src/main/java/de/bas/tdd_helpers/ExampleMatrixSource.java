package de.bas.tdd_helpers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleMatrixSource implements MatrixSource {
    boolean toggle = true;
    char[][] array;
    int x=2;
    int y=2;
    int step=1;

    private final static Logger LOGGER = Logger.getLogger(ExampleMatrixSource.class.getName());
    public ExampleMatrixSource(char[][] array) {
        this.array = array;
        LOGGER.setLevel(Level.INFO);

    }

    public char[][] getNextMatrix() {
        // calculate the next matrix, this example just plots random noise, you need to implement the game instead
        // return getrandomMatrix();
        // getregularMatrix();

        return getDiagonalRunningSquareArray();
    }

    private char[][] getDiagonalRunningSquareArray() {
        if (y>0 && x>0 && step == 1)
            array[y-step][x-step]=MatrixPaneConverter.WHITE_CELL;

        if (y<array.length-1 && x<array[0].length-1 && step == -1)
            array[y-step][x-step]=MatrixPaneConverter.WHITE_CELL;

        if (y>= array.length || x>= array[0].length){
            step = -1;
        }
        if (y< 0 || x< 0){
            step = 1;
        }

        if (y< array.length && x< array[0].length && y>=0 && x>=0) {
            array[y][x] = MatrixPaneConverter.BLACK_CELL;
        }

        x=x+step;
        y=y+step;

        String logstring ="\n";
        for (int y = 0; y < array.length; y++) {
            logstring = logstring + y + ":" + String.valueOf(array[y])+"\n";
        }
        LOGGER.log(Level.FINE, logstring );
        return array;
    }




    public boolean decideFor(int x, int y) {
        return false;
    }

    public int getSizeX() {
        return array[0].length;
    }

    public int getSizeY() {
        return array.length;
    }
}
