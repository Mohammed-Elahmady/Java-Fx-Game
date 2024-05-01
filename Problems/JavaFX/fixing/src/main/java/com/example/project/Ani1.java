package com.example.project;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ani1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        Scene scene =new Scene(pane,600,400);


        Circle C1 = new Circle(100);
        C1.centerXProperty().bind(scene.widthProperty().divide(2));
        C1.centerYProperty().bind(scene.heightProperty().divide(2));

        Rectangle R1 = new Rectangle(0,0,70,50);
        R1.setY(745/2);
        R1.setX(1465/2+100);
        R1.setFill(Color.GREEN);

        C1.setFill(Color.RED);
        C1.setStroke(Color.BLUE);
        pane.getChildren().addAll(C1,R1);



        PathTransition P1 =new PathTransition();
        P1.setPath(C1);
        P1.setNode(R1);
        P1.setDuration(Duration.millis(4000));
        P1.setCycleCount(Timeline.INDEFINITE);
        P1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        C1.setOnMouseClicked(e-> P1.pause());
        C1.setOnKeyReleased(e-> P1.play());

        primaryStage.show();
        primaryStage.setScene(scene);

    }
}
