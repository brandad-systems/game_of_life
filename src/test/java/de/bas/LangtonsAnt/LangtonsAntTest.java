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
    void test_new_direction_of_ant_based_on_cell_color_black_and_when_current_direction_is_west() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.WEST);
        langtonsAnt.setNewDirection(0,0);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_black_and_when_current_direction_is_south() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.SOUTH);
        langtonsAnt.setNewDirection(0,0);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_white_and_when_current_direction_is_east() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.EAST);
        langtonsAnt.setNewDirection(0,1);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_white_and_when_current_direction_is_south() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.SOUTH);
        langtonsAnt.setNewDirection(0,1);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_white_and_when_current_direction_is_west() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.WEST);
        langtonsAnt.setNewDirection(0,1);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void test_new_direction_of_ant_based_on_cell_color_white_and_when_current_direction_is_north() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.NORTH);
        langtonsAnt.setNewDirection(0,1);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void test_color_changed_from_white_to_black_when_ant_has_already_moved_to_new_cell() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.NORTH);
        langtonsAnt.setNewCellColor(0,1);
        assertThat(langtonsAnt.getCurrentCellColor(0,1)).isEqualTo(BLACK_CELL);
    }


    @Test
    void test_color_changed_from_black_to_white_when_ant_has_already_moved_to_new_cell() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.NORTH);
        langtonsAnt.setNewCellColor(0,0);
        assertThat(langtonsAnt.getCurrentCellColor(0,1)).isEqualTo(WHITE_CELL);
    }

    @Test
    @Disabled
    void test_ant_moves_to_new_cell_when_current_cell_is_white_and_direction_is_east() {
        var langtonsAnt = new LangtonsAnt(board,0,1, Direction.EAST);
        langtonsAnt.moveAnt(0,1);
        assertThat(langtonsAnt.getCurrentCellColor(1,0)).isEqualTo(BLACK_CELL);
        assertThat(langtonsAnt.getCurrentDirection()).isEqualTo(Direction.SOUTH);
    }



    @Test
    @Disabled
    void test_color_of_cell_not_in_matrix() {
        var langtonsAnt = new LangtonsAnt(board,0,0, Direction.EAST);

        assertThat(langtonsAnt.getCurrentCellColor(-1,-1)).isEqualTo(BLACK_CELL);
    }

}