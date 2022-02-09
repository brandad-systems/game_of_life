package de.bas.LangtonsAnt;

import de.bas.tdd_helpers.MatrixPaneConverter;

public class LangtonsAnt {


    private char[][] board;
    private Direction currentDirection;

    LangtonsAnt(char[][] board, int antX, int antY, Direction antDirection) {
        //...if randomInit is true then  array content (but not  array.size), antX, etc. are ignored and generated as valid random values,
        this.board = board;
        this.currentDirection = antDirection;
    }

    // gives back color of the current cell where the ant is.
    public char getCurrentCellColor(int x, int y) {
        return board[x][y];
    }

    // gets the current direction of the ant
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setNewDirection(int x, int y) {

        char currentColor = getCurrentCellColor(x, y);

        if (currentColor == MatrixPaneConverter.WHITE_CELL) {
           /* if (currentDirection.getValue() == 3) {
                currentDirection = Direction.NORTH;
            }
            currentDirection = Direction.get(currentDirection.getValue() + 1);*/
        }

        /*if (currentColor == MatrixPaneConverter.BLACK_CELL) {
            if (currentDirection.getValue() == 0) {
                currentDirection = Direction.WEST;
            }
            currentDirection = Direction.get(currentDirection.getValue() - 1);
        }*/

        currentDirection = Direction.NORTH;
    }

    // rotate the ant based on cell color and current direction

    public enum Direction {
        NORTH(0),
        EAST(1),
        SOUTH(2),
        WEST(3);

        private final int value;

        Direction(final int newValue) {
            value = newValue;
        }

        public static Direction get(int index) {
            return Direction.values()[index];
        }

        public int getValue() {
            return value;
        }


    }
    // flip color of current cell

    // move the ant based on current direction and next direction

}
