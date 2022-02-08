package de.bas.tdd_helpers;

import de.bas.tdd_helpers.MatrixPaneConverter;
import de.bas.tdd_helpers.MatrixSource;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;


import static de.bas.tdd_helpers.MatrixPaneConverter.DEAD_CELL;
import static de.bas.tdd_helpers.MatrixPaneConverter.LIVING_CELL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MatrixPaneConverterTest {
    @Test
    void firstTest(){
        char X = LIVING_CELL;
        char O = DEAD_CELL;
        MatrixSource ms = mock(MatrixSource.class);
        char[][] testarray = {{X,O,O},{O,O,O},{O,O,O},{O,O,X}};
        when(ms.getNextMatrix()).thenReturn(testarray);
        when(ms.getSizeX()).thenReturn(testarray[0].length);
        when(ms.getSizeY()).thenReturn(testarray.length);
        MatrixPaneConverter mpc = new MatrixPaneConverter(ms);
        Pane pane = mpc.getNextPane();
        assertThat(pane.getChildren().size()).isEqualTo(4);
        assertThat(pane.getChildren().get(0)).isInstanceOf(Text.class);
        assertThat(((Text)pane.getChildren().get(0)).getText()).contains("■  ");
        assertThat(((Text)pane.getChildren().get(3)).getText()).contains("  ■");
    }


}
