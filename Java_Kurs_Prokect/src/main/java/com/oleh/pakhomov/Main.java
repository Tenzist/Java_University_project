package com.oleh.pakhomov;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    protected static Scene scene;
    public static FXMLLoader loader;
    public static SceneController controller;

    static {
        try {
            loader = new FXMLLoader(Main.class.getResource("func-view.fxml"));
            scene = new Scene(loader.load());
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("f(x) -> min");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }
    public static void main(String[] args) {
        launch();
    }
}