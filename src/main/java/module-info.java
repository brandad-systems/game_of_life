module de.bas.game_of_life {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.bas.game_of_life to javafx.fxml;
    exports de.bas.game_of_life;
}