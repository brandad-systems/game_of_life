package de.bas.game_of_life;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MatrixPaneConverter {

    private final MatrixSource matrixSource;
    static char LIVING_CELL = '■';
    static char DEAD_CELL = ' ';

    public MatrixPaneConverter(MatrixSource matrixSource) {
        this.matrixSource = matrixSource;
    }

    public Pane getNextPane() {
        char[][] array = matrixSource.getNextMatrix();
        Pane pane = new Pane();
        for (int y = 0; y < array.length; y++) {
            Text textLine = new Text();
            // textLine.setFont(Font.font ("Verdana", 8));
            textLine.setStyle("-fx-font-family: 'monospaced';-fx-font-size: 10");
            String line ="";
            for (int x = 0; x < array[0].length; x++) {
                line= line + array[y][x];
            }
            textLine.setText( line);
            textLine.setX(0);
            textLine.setY(y*6.5+8);
            pane.getChildren().add(textLine);
        }
        return pane;
    }
}
