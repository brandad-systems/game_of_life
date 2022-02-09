package de.bas.LangtonsAnt;

import de.bas.tdd_helpers.MatrixPaneConverter;

public class LangtonsAnt {

    private char[][] board;
    private Direction currentDirection;
    private char currentCellColor;

    LangtonsAnt(char[][] board, int antX, int antY, Direction antDirection) {
        //...if randomInit is true then  array content (but not  array.size), antX, etc. are ignored and generated as valid random values,
        this.board = board;
        this.currentDirection = antDirection;
    }

    // gives back color of the current cell where the ant is.
    public char getCurrentCellColor(int x, int y) {
        this.currentCellColor = board[x][y];
        return currentCellColor;
    }


    // gets the current direction of the ant
    public Direction getCurrentDirection() {
        return currentDirection;
    }


    // rotate the ant based on cell color and current direction

    public void setNewDirection(int x, int y) {

        var currentCellColor = getCurrentCellColor(x, y);

        if (currentCellColor == MatrixPaneConverter.WHITE_CELL) {
            currentDirection = (currentDirection.getValue() == 3) ? Direction.NORTH :
                    Direction.get(currentDirection.getValue() + 1);
        }

        if (currentCellColor == MatrixPaneConverter.BLACK_CELL) {
            currentDirection = (currentDirection.getValue() == 0) ? Direction.WEST :
                    Direction.get(currentDirection.getValue() - 1);
        }
    }


    // flip color of current cell


    public void setNewCellColor(int x, int y) {

        var currentCellColor = getCurrentCellColor(x, y);

        board[x][y] = (currentCellColor == MatrixPaneConverter.WHITE_CELL)? MatrixPaneConverter.BLACK_CELL:MatrixPaneConverter.WHITE_CELL;

    }

    // move the ant based on current direction and next direction

    public void moveAnt(int x, int y) {

        var currentCellColor = getCurrentCellColor(x,y);
        var currentDirection = getCurrentDirection();

    }

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

}
