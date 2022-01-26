package de.bas.game_of_life;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    static char LIVING_CELL = '■';
    static char DEAD_CELL = ' ';
    @Test
    void calculateAliveNeighbours() {

    }


    @Test
    void isAlive_when_Board_IS_NULL() {
        var gameOfLife = new GameOfLife(null);
        assertThat(gameOfLife.isAlive(0,0)).isFalse();
    }

    @Test
    void isAlive() {
        char [][] board= new char[][]{
                {DEAD_CELL,DEAD_CELL},  // x=0;y=0;    x=1;y=0
                {LIVING_CELL,DEAD_CELL} // x=0;y=1;    x=1;y=1
        };
        var gameOfLife = new GameOfLife(board);
        assertThat(gameOfLife.isAlive(0,1)).isTrue();
        assertThat(gameOfLife.isAlive(-1,-1)).isFalse();
        assertThat(gameOfLife.isAlive(2,2)).isFalse();
    }
}