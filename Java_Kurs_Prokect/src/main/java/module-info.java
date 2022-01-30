module com.oleh.pakhomov {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;
    requires com.google.gson;
    requires org.testfx;
    requires org.testfx.junit;
    requires org.assertj.core;
    requires javafx.graphics;
    requires javafx.base;

    opens com.oleh.pakhomov to javafx.fxml;
    exports com.oleh.pakhomov;
}