package de.bas.game_of_life;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    static char LIVING_CELL = '■';
    static char DEAD_CELL = ' ';

    @Test
    void calculateNextGenerationCellState_should_return_alive_cell_with_3_alive_neighbours() {
        char[][] board = new char[][]{
                {DEAD_CELL, LIVING_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, LIVING_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateNextGenerationCellState(0,0)).isEqualTo(LIVING_CELL);
    }

    @Test
    void calculateNextGenerationCellState_should_stay_dead_cell_with_2_alive_neighbours() {
        char[][] board = new char[][]{
                {DEAD_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, LIVING_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateNextGenerationCellState(0,0)).isEqualTo(DEAD_CELL);
    }

    @Test
    void calculateNextGenerationCellState_should_stay_live_cell_with_2_alive_neighbours() {
        char[][] board = new char[][]{
                {LIVING_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, LIVING_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateNextGenerationCellState(0,0)).isEqualTo(LIVING_CELL);
    }

   /*
    1. Any live cell with fewer than two live neighbours dies, ✔
    as if caused by underpopulation.
    2. Any live cell with more than three live neighbours dies, ✔
    as if by overcrowding.
    3. Any live cell with two or three live neighbours lives
    on to the next generation.
    4. Any dead cell with exactly three live neighbours becomes
    a live cell.*/
   @Test
   void calculateNextGenerationCellState_should_return_dead_cell_with_more_than_3_alive_neighbours() {
       char[][] board = new char[][]{
               {LIVING_CELL, LIVING_CELL, LIVING_CELL},  // x=0;y=0;    x=1;y=0   x=2;y=0
               {LIVING_CELL, LIVING_CELL, DEAD_CELL} // x=0;y=1;        x=1;y=1   x=2;y=1
       };
       var gameOfLife = new GameOfLife(board);
       assertThat(gameOfLife.calculateNextGenerationCellState(1,1)).isEqualTo(DEAD_CELL);
   }

    @Test
    void calculateNextGenerationCellState_should_return_dead_cell_with_less_than_2_alive_neighbours() {
        char[][] board = new char[][]{
                {LIVING_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, DEAD_CELL} // x=0;y=1;        x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateNextGenerationCellState(0,0)).isEqualTo(DEAD_CELL);
    }

    @Test
    void calculateNextGenerationCellState_should_return_dead_cell_with_zero_alive_neighbours() {
        char[][] board = new char[][]{
                {LIVING_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {DEAD_CELL, DEAD_CELL} // x=0;y=1;        x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateNextGenerationCellState(0,0)).isEqualTo(DEAD_CELL);
    }

    @Test
    void calculateAliveNeighbours() {
        char[][] board = new char[][]{
                {DEAD_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, DEAD_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateAliveNeighbours(0,0)).isEqualTo(1);
    }

    @Test
    void calculateAliveNeighbours_out_of_bounds_living_cell_in_range() {
        char[][] board = new char[][]{
                {LIVING_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, DEAD_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateAliveNeighbours(-1,-1)).isEqualTo(1);
    }

    @Test
    void calculateAliveNeighbours_out_of_bounds_dead_cell_in_range() {
        char[][] board = new char[][]{
                {DEAD_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, DEAD_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.calculateAliveNeighbours(-1,-1)).isEqualTo(0);
    }

    @Test
    void isAlive_when_Board_IS_NULL() {
        var gameOfLife = new GameOfLife(null);
        assertThat(gameOfLife.isAlive(0, 0)).isFalse();
    }

    @Test
    void isAlive() {
        char[][] board = new char[][]{
                {DEAD_CELL, DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL, DEAD_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.isAlive(0, 1)).isTrue();
        assertThat(gameOfLife.isAlive(-1, -1)).isFalse();
        assertThat(gameOfLife.isAlive(2, 2)).isFalse();
    }

    @Test
    void isAlive_invalidBoard() {
        char[][] board = new char[][]{
                {'A', 'B'},  // x=0;y=0;    x=1;y=0
                {'C', 'D'} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.isAlive(0, 0)).isFalse();
    }

}