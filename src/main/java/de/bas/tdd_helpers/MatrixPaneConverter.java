package de.bas.tdd_helpers;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MatrixPaneConverter {

    private final MatrixSource matrixSource;
    //these two definitions are for the Game of Live
    public static char LIVING_CELL = '■';
    public static char DEAD_CELL = ' ';

    //and these two definitions are for the Langton's Ant:
    public static char BLACK_CELL = '■';
    public static char WHITE_CELL = ' ';

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
