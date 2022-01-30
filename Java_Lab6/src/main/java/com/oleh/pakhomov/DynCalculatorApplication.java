package com.oleh.pakhomov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DynCalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DynCalculatorApplication.class.getResource("dynamic-calc-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dynamic calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}