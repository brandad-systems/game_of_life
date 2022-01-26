package de.bas.game_of_life;

import static de.bas.game_of_life.MatrixPaneConverter.DEAD_CELL;
import static de.bas.game_of_life.MatrixPaneConverter.LIVING_CELL;

public class GameOfLife {
    char[][] board;

    public GameOfLife(char[][] board) {
        this.board = board;
    }

    // return no. of alive neighbours of char in position x,y
    int calculateAliveNeighbours(int x, int y) {
        int count = 0;
        for (int row = x - 1; row <= x + 1; row++) {
            for (int column = y - 1; column <= y + 1; column++) {
                if (!(row == x && column == y) && isAlive(row, column))
                    count++;
            }
        }
        return count;
    }

    boolean isAlive(int x, int y) {
        if (board == null || x < 0 || y < 0 || y >= board.length || x >= board[0].length) {
            return false;
        }
        return returnState(x,y) == LIVING_CELL;
    }

    char calculateNextGenerationCellState(int x, int y) {

        int count = calculateAliveNeighbours(x,y);
        if(count < 2 || count> 3) return DEAD_CELL;
        if(count == 3) return LIVING_CELL;
        return returnState(x,y);
    }

    private char returnState(int x, int y){
        return board[y][x];
    }

}
