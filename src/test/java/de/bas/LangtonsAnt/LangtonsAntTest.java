package de.bas.LangtonsAnt;

import de.bas.LangtonsAnt.LangtonsAnt.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LangtonsAntTest {


    public static char BLACK_CELL = '■';
    public static char WHITE_CELL = ' ';
    char[][] board;

    @BeforeEach
    void init() {
    board = new char[][]
        {
            {BLACK_CELL, WHITE_CELL},
            {WHITE_CELL, WHITE_CELL}
        };
    }

    @Test
    void test_color_of_current_cell_matches() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.EAST);

        assertThat(langtonsAnt.getCurrentCellColor(0,0)).isEqualTo(BLACK_CELL);
    }

    @Test
    void test_get_current_direction_of_ant() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.EAST);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_black_and_when_current_direction_is_east() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.EAST);
        langtonsAnt.setNewDirection(0,0);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_black_and_when_current_direction_is_north() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.NORTH);
        langtonsAnt.setNewDirection(0,0);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    @Disabled
    void test_color_of_cell_not_in_matrix() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.EAST);

        assertThat(langtonsAnt.getCurrentCellColor(-1,-1)).isEqualTo(BLACK_CELL);
    }

}