module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens ucf.assignments to javafx.fxml, javafx.base;
    exports ucf.assignments to javafx.graphics, javafx.base;
}