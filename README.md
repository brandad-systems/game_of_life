# game_of_live
template for the classic Game of Live  for TestDrivenDevelopment TDD practice

## Implementation Rules:
- Implement a `de.bas.game_of_life.GameOfLive.java` class, according to these "Game of Live"- rules [here](https://github.com/garora/TDD-Katas/blob/main/KatasReadme.md)
- Start with `de.bas.game_of_life.GameOfLiveTest.java` unit test
- brake down all the functionality you will need into small chunks i.e. methods not longer then 9-11 lines for each method, so that they can be easily unit-tested.
- write **all** the tests **before** the implementation. 
- but write an **empty** class of `de.bas.game_of_life.GameOfLive.java` with  the **empty** methods you plan **even before** the tests
- the playing field should be a simple `char[][]` array, prefilled with you test data, which is given in the constructor.
- make sure that `de.bas.game_of_life.GameOfLive.java` to implements the interface `e.bas.game_of_life.GameOfLive.MatrixSource.java`
- make sure everything is thourougly tested.

## final integration into the javafx - MatrixSequenceViewer
add the following constructor to `de.bas.game_of_life.GameOfLive.java`:
```java
//...
public class GameOfLive implements MatrixSource {
  GameOfLive(char[][] array, boolean randomInit) {
    //...
  } //...
} 
```
with these constaints:
- if `randomInit` is false , then `array` given is expected to  be initialized with  
  - `MatrixPaneConverter.LIVING_CELL` , which is the `char` `'■'` or
  - `MatrixPaneConverter.DEAD_CELL` , which is the `space` `char` `' '`;
  **before** the constuctor of GameOfLive
- or, if `randomInit` is `true`, the array need not be initialized but only allocated with `new`, before calling the Constructor of GameOfLive. Then the Constructor should replace the content by random with '■' or ' ' for each element of the `array`.

the goal is, not to need to fix anything (apart from the Constructor and the initialization ) in `de.bas.game_of_life.GameOfLive.java` after its integrated with the
`de.bas.game_of_life.MatrixSequenceViewer.java`

don't bother with `MatrixPaneConverter`, `RandomMatrixSource`, you don't need this.
Finaly just uncomment line 24 in `MatrixSequenceViewer` and comment in line 24 instead.
then run `MatrixSequenceViewer`

