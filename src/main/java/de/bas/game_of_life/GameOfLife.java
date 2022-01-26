package de.bas.game_of_life;

import static de.bas.game_of_life.MatrixPaneConverter.LIVING_CELL;

public class GameOfLife {
    char [][] board;

    public GameOfLife(char[][] board) {
        this.board = board;
    }

    int calculateAliveNeighbours(int x, int y){
        // return no. of alive neighbours of char in position x,y
    return 0;
    }

    boolean isAlive(int x, int y) {
        if(board == null || x < 0 || y < 0 || y >= board.length || x >= board[0].length) {
            return false;
        }
        return board[y][x] == LIVING_CELL;
    }

}
