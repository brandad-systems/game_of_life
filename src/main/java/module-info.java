module de.bas.game_of_life {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens de.bas.game_of_life to javafx.fxml;
    exports de.bas.game_of_life;
    exports de.bas.tdd_helpers;
    opens de.bas.tdd_helpers to javafx.fxml;
}