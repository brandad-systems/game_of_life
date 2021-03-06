package de.bas.game_of_life;

import de.bas.tdd_helpers.MatrixSource;

import java.util.Arrays;
import java.util.Random;

import static de.bas.tdd_helpers.MatrixPaneConverter.DEAD_CELL;
import static de.bas.tdd_helpers.MatrixPaneConverter.LIVING_CELL;

public class GameOfLife implements MatrixSource {
    char[][] board;

    @Override
    public int getSizeX() {
        return board[0].length;
    }

    @Override
    public int getSizeY() {
        return board.length;
    }

    @Override
    public char[][] getNextMatrix() {
        calculateNewGeneration();
        return board;
    }

    private boolean isValid(char[][] board, boolean randomInit){
        if (board == null){
            return false;
        }

        if(!randomInit) {
            for (int x = 0; x < board[0].length; x++) {
                for (int y = 0; y < board.length; y++) {
                    if (board[y][x] != LIVING_CELL && board[y][x] != DEAD_CELL) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public GameOfLife(char[][] initBoard) {
        if(!isValid(initBoard, false)){
            throw new IllegalArgumentException();
        }
        this.board = Arrays.stream(initBoard)
                .map(char[]::clone)
                .toArray((char[][]::new));
    }

    public GameOfLife(char[][] initBoard, boolean randomInit) {
        if(!isValid(initBoard, randomInit)){
            throw new IllegalArgumentException();
        }
        this.board = Arrays.stream(initBoard)
                .map(char[]::clone)
                .toArray((char[][]::new));


        if(randomInit) {
            var random = new Random();
            for (int x = 0; x < getSizeX(); x++) {
                for (int y = 0; y < getSizeY(); y++) {
                    this.board[y][x] = random.nextBoolean() ? LIVING_CELL : DEAD_CELL;
                }
            }
        }
    }

    void calculateNewGeneration(){
        var newBoard = new char[getSizeY()][getSizeX()];
        for (int x = 0; x < getSizeX(); x++) {
            for (int y = 0; y < getSizeY(); y++) {
                newBoard[y][x] = calculateNextGenerationCellState(x, y);
            }
        }
        board = newBoard;
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
        if (board == null || x < 0 || y < 0 || y >= getSizeY() || x >= getSizeX()) {
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
