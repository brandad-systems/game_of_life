package de.bas.game_of_life;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MatrixSequenceViewer extends Application {
    Scene scene;
    long frameCounter=0;
    long lastTimeStamp = 0;
    MatrixPaneConverter paneSource;
    @Override
    public void start(Stage stage)  {

        char[][] startArray = new char[60][60];

        int sizex = startArray[0].length;
        int sizey = startArray.length;
        MatrixSource gameOfLive = new RandomMatrixSource(startArray);
        //MatrixSource gameOfLive = new GameOfLive(startArray,true);

        paneSource = new MatrixPaneConverter(gameOfLive);
        stage.setTitle("Hello!");
        Pane pane = paneSource.getNextPane();
        scene = new Scene(pane ,sizex*6.1,sizey*6.6);
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
                scene.setRoot(paneSource.getNextPane());
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}