package com.example.project;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Move extends Application {

    private static final int RECTANGLE_WIDTH = 50;
    private static final int RECTANGLE_HEIGHT = 50;
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 400;
    private static final int GROUND_LEVEL = SCENE_HEIGHT - RECTANGLE_HEIGHT;

    private Rectangle rectangle;
    private boolean jump = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private double yVelocity = 0;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Create the rectangle
        rectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        rectangle.setFill(Color.BLUE);
        rectangle.setLayoutX(50); // Initial X position
        rectangle.setLayoutY(GROUND_LEVEL); // Initial Y position

        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        // Handle keyboard input
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                movingLeft = true;
            } else if (e.getCode() == KeyCode.D) {
                movingRight = true;
            } else if (e.getCode() == KeyCode.SPACE && !jump) {
                jump();
            }
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.A) {
                movingLeft = false;
            } else if (e.getCode() == KeyCode.D) {
                movingRight = false;
            }
        });

        // Update the scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Moving Rectangle");
        primaryStage.show();

        // Update the position of the rectangle in the animation timer
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Move left
                if (movingLeft && rectangle.getX() > 0) {
                    rectangle.setX(rectangle.getX() - 5);
                }
                // Move right
                if (movingRight && rectangle.getX() < 1390 ) {
                    rectangle.setX(rectangle.getX() + 5);
                }
                // Jump
                if (jump) {
                    yVelocity = -10; // Initial jump velocity
                    jump = false;
                }
                // Apply gravity
                yVelocity += 0.5;
                rectangle.setY(rectangle.getY() + yVelocity);
                // Keep the rectangle on the ground
                if (rectangle.getY() >= GROUND_LEVEL) {
                    rectangle.setY(GROUND_LEVEL);
                    yVelocity = 0;
                }
            }
        }.start();
    }

    // Method to make the rectangle jump
    private void jump() {
        jump = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}