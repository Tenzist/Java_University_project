module com.oleh.pakhomov {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;
    requires java.desktop;


    opens com.oleh.pakhomov to javafx.fxml;
    exports com.oleh.pakhomov;
}