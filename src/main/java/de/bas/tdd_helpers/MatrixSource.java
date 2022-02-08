package de.bas.tdd_helpers;

public interface MatrixSource {
    int getSizeX();
    int getSizeY();
    char[][] getNextMatrix();
}

// constructor:
//public GameOfLive(char[][] array,boolean randomInit) ;
// if randomInit is false , then array needs to be initialized with
//    MatrixPaneConverter.LIVING_CELL , which is '■' or
//    MatrixPaneConverter.DEAD_CELL , which is  ' ';
// or if randomInit is true, the array must be initialized, but content will be replaced by random '■' or ' '.
