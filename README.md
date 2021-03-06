# game_of_live or Langton's Ant
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

or for Langton's Ant: 
```java
//...for Langton's Ant:
public class LangtonsAnt implements MatrixSource {
  LangtonsAnt(char[][] array, int antX, int antY, String antDirection,boolean randomInit ) {
    //...if randomInit is true then  array content (but not  array.size), antX, etc. are ignored and generated as valid random values, 
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

## Example arrays/steps for "Langton's Ant":

Find the ONE error in  the following example steps! and add another step at the end!

### example start 6x6 array:  the ant on x=2,y=3, direction=west,  "." is a white field, "■" is a black field
```
......
..■...
...■..
..*...
......
......
```
with the ant on x=2,y=3, direction=west,

### next step (1)  according to the rules: 
- At a white square, turn 90° clockwise, flip the color of the square, move forward one unit
- At a black square, turn 90° counter-clockwise, flip the color of the square, move forward one unit
- **NEW**: when ant is facing to the border of the board, it does NOT move forward, but still does flip the color of the square and roteate according to rule 1 and 2
  would be:
```
......
..■...
..*■..
..■...
......
......
```
while ants position is now x=2,y=2 , direction north (because ant was on a white field): 

### next step  (2) according to the rules

```
......
..■...
..■✪..
..■...
......
......
```
ant position x=3, y=2, direction=east (because ant was on a white field), 

### next step  (3) according to the rules
```
......
..■*..
..■...
..■...
......
......
```
ant position : x=3, y=1 , direktion north (because last field was a black field)

### next step  (4) according to the rules
```
......
..■■*.
..■...
..■...
......
......
```
ant position : x=4, y=1 , direktion east (because last field was a white field)