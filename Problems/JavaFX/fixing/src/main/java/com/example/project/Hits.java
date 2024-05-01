package com.example.project;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hits extends Application {

    private static final int RECTANGLE_WIDTH = 50;
    private static final int RECTANGLE_HEIGHT = 50;
    private static final int SMALL_BOX_SIZE = 20;
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 400;
    private static final int GROUND_LEVEL = SCENE_HEIGHT - RECTANGLE_HEIGHT;

    private Rectangle rectangle;
    private boolean jump = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private double yVelocity = 0;
    private List<Rectangle> smallBoxes = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Create the rectangle
        rectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        rectangle.setFill(Color.BLUE);
        rectangle.setLayoutX(50); // Initial X position
        rectangle.setLayoutY(GROUND_LEVEL); // Initial Y position

        root.getChildren().add(rectangle);

        // Create small boxes
        createSmallBoxes(root);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        // Handle keyboard input
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                movingLeft = true;
            } else if (e.getCode() == KeyCode.D) {
                movingRight = true;
            } else if (e.getCode() == KeyCode.SPACE && !jump) {
                jump();
            } else if (e.getCode() == KeyCode.K) {
                hitSmallBoxes();
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
                if (movingRight && rectangle.getX() < SCENE_WIDTH - RECTANGLE_WIDTH) {
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

    // Method to create small boxes
    private void createSmallBoxes(Pane root) {
        for (int i = 0; i < 10; i++) {
            Rectangle smallBox = new Rectangle(SMALL_BOX_SIZE, SMALL_BOX_SIZE);
            smallBox.setFill(Color.RED);
            smallBox.setLayoutX((i + 1) * 50); // Adjust the position of small boxes
            smallBox.setLayoutY(GROUND_LEVEL - SMALL_BOX_SIZE);
            smallBoxes.add(smallBox);
            root.getChildren().add(smallBox);
        }
    }

    // Method to check collision between rectangle and small boxes
    private void hitSmallBoxes() {
        Iterator<Rectangle> iterator = smallBoxes.iterator();
        while (iterator.hasNext()) {
            Rectangle smallBox = iterator.next();
            if (rectangle.getBoundsInParent().intersects(smallBox.getBoundsInParent())) {
                iterator.remove();
                smallBox.setFill(Color.TRANSPARENT);
                // Add your desired action when the rectangle hits a small box
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
