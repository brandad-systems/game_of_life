package de.bas.game_of_life;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMatrixSource implements MatrixSource {
    boolean toggle = true;
    char[][] array;


    public RandomMatrixSource(char[][] array) {
        this.array = array;
    }

    public char[][] getNextMatrix() {
        array = new char[array.length][array[0].length];
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
                array[y][x] = Integer.toString(randomNum).charAt(0);
            }
        }
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
