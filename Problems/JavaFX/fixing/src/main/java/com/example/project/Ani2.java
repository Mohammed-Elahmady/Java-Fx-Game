package com.example.project;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ani2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Ellipse e1 = new Ellipse(250,250,50,70);
        e1.setFill(Color.GREEN);
        e1.setStroke(Color.BLUE);
        FadeTransition f1 = new FadeTransition(Duration.millis(1000),e1);
        Pane pane = new Pane(e1);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        f1.setCycleCount(Timeline.INDEFINITE);
        f1.setFromValue(0);
        f1.setByValue(0.1);
        f1.setToValue(1);
        f1.setAutoReverse(true);
        f1.play();



    }
}
