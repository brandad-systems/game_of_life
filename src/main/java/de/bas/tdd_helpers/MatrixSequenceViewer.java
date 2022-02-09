package de.bas.tdd_helpers;

import de.bas.game_of_life.GameOfLife;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class MatrixSequenceViewer extends Application {
    Scene scene;
    long frameCounter=0;
    long lastTimeStamp = 0;
    MatrixPaneConverter paneSource;
    @Override
    public void start(Stage stage)  {

        char[][] startArray = new char[150][200];

        int sizex = startArray[0].length;
        int sizey = startArray.length;
        for (int y = 0; y < startArray.length; y++) {
            for (int x = 0; x < startArray[0].length; x++) {
                startArray[y][x] = ' ';
            }
        }
//        MatrixSource theGame = new ExampleMatrixSource(startArray);
        // to use your solution for 'game of live' or 'Langton's Ant'
        MatrixSource theGame = new GameOfLife(startArray,true);
        //MatrixSource theGame = new LangtonsAnt(startArray,true);

        paneSource = new MatrixPaneConverter(theGame);
        stage.setTitle("Hello!");
        Pane pane = paneSource.getNextPane();
        scene = new Scene(pane ,sizex*6.1,sizey*6.6);
        //scene = new Scene(pane ,sizex*10,sizey*10);
        AnimationTimer timer = new MyTimer();
        timer.start();
        stage.setScene(scene);
        stage.show();
    }
    private class MyTimer extends AnimationTimer {
        @Override
        public void handle(long now) {
            //change pane every 1/10 second
            if ( now > lastTimeStamp + 1000*1000*100){
                System.out.println("framecounter= " + frameCounter );
                lastTimeStamp =   now ;
                frameCounter++;
                Pane nextP = paneSource.getNextPane();
                scene.setRoot(nextP);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
