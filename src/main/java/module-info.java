module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;

    opens ucf.assignments to javafx.fxml, javafx.base;
    exports ucf.assignments to javafx.graphics, javafx.base;
}