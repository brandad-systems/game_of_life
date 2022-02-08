# game_of_live
template for the classic "Game of Live" or "Langton's Ant"  for TestDrivenDevelopment TDD practice



## Implementation Rules:
- Implement a `de.bas.game_of_life.<GameName>.java` class, according to 
  - these "Game of Live"- rules [here](https://github.com/garora/TDD-Katas/blob/main/KatasReadme.md)
  - or these rules [here](https://en.wikipedia.org/wiki/Langton%27s_ant)
- Start with `de.bas.game_of_life.<GameName>Test.java` unit test
- brake down all the functionality you will need into small chunks i.e. methods not longer then 9-11 lines for each method, so that they can be easily unit-tested.
- write **all** the tests **before** the implementation. 
- but write an **empty** class of `de.bas.game_of_life.<GameName>.java` with  the **empty** methods you plan **even before** the tests
- the playing field should be a simple `char[][]` array, prefilled with you test data, which is given in the constructor.
- make sure that `de.bas.game_of_life.<GameName>.java` to implements the interface `e.bas.game_of_life.MatrixSource.java`
- make sure everything is thourougly tested.

## final integration into the javafx - MatrixSequenceViewer
add the following constructor to `de.bas.game_of_life.<GameName>.java`:
```java
//...for Game of Live:
public class GameOfLive implements MatrixSource {
  GameOfLive(char[][] array, boolean randomInit) {
    //...
  } //...
} 
```
with these constaints:
- if `randomInit` is false , then `array` given to the Constructor is expected to  be initialized with  
  - `MatrixPaneConverter.LIVING_CELL` , which is the `char` `'■'`
  - or `MatrixPaneConverter.DEAD_CELL` , which is the `space` `char` `' '`; 
  - and **before** calling the constuctor of GameOfLive
- or, if `randomInit` is `true`, the array need not be initialized but only allocated with `new`, before calling the Constructor of GameOfLive. Then the Constructor should replace the content by random with '■' or ' ' for each element of the `array`.

the goal is, not to need to fix anything (apart from the Constructor and the initialization ) in `de.bas.game_of_life.<GameName>.java` after its integrated with the
`de.bas.tdd_helpers.MatrixSequenceViewer.java`

Use 2 of the 4 statics in `MatrixPaneConverter` (`MatrixPaneConverter.LIVING_CELL` ... `MatrixPaneConverter.WHITE_CELL` ) but don't bother with the rest of `MatrixPaneConverter`, `ExampleMatrixSource`, you don't need this.
Finaly just uncomment line 23 or 24 in `MatrixSequenceViewer` and comment in line 21 instead.
then run `MatrixSequenceViewer`

