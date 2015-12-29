package com.soul.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main method for the quiz UI.
 * Created by Mitchell on 12/22/2015.
 */
public class HeroesQuizzerUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Heroes Quizzer");
        Scene scene = new Scene(root, 1000, 500);
        scene.getStylesheets().add("com/soul/ui/start.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
