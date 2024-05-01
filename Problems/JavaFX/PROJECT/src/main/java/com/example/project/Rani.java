package com.example.project;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class Rani extends Application {

    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 400;
    private static final int R2_SIZE = 50;

    private double R2X = SCENE_WIDTH - R2_SIZE;
    private double R2Y = SCENE_HEIGHT - R2_SIZE;
    private double velocityX = 7;
    private double velocityY = 0;

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Moving R2");

        Rectangle R2 = new Rectangle(R2X, R2Y, R2_SIZE, R2_SIZE);
        R2.setFill(Color.BLUE);
        root.getChildren().add(R2);

         new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveR2(primaryStage);
            }
        }.start();


    }

    private void moveR2(Stage primaryStage) {
        R2X += velocityX;
        R2Y += velocityY;

        // Randomly change direction
        if (random.nextDouble() < 0.01) {
            velocityX *= -1; // Change direction
        }

        // Jump if on the ground
        if (R2Y >= SCENE_HEIGHT - R2_SIZE) {
            if (random.nextDouble() < 0.01) {
                velocityY = -7; // Jump
            } else {
                velocityY = 0; // Reset velocity if not jumping
            }
        } else {
            velocityY += 0.5; // Apply gravity
        }

        // Ensure the R2 stays within the scene bounds
        if (R2X <= 0 || R2X >= SCENE_WIDTH - R2_SIZE) {
            velocityX *= -1; // Reverse direction if hitting the sides
        }

        // Update the R2's position
        Rectangle R2 = new Rectangle(R2X, R2Y, R2_SIZE, R2_SIZE);
        R2.setFill(Color.BLUE);

        ((Pane) primaryStage.getScene().getRoot()).getChildren().set(0, R2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
