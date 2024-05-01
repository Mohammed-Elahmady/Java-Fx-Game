package com.example.project;
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
    private static final double MOVEMENT_SPEED = 5;
    private static final double JUMP_VELOCITY = -10;
    private static final int MAX_JUMPS = 2;

    private Rectangle rectangle;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private int jumps = 0;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        rectangle = new Rectangle(RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        rectangle.setFill(Color.BLUE);
        rectangle.setLayoutX(50);
        rectangle.setLayoutY(GROUND_LEVEL);

        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        scene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
        scene.setOnKeyReleased(e -> handleKeyRelease(e.getCode()));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Moving Rectangle");
        primaryStage.show();
    }

    private void handleKeyPress(KeyCode code) {
        if (code == KeyCode.A) {
            movingLeft = true;
        } else if (code == KeyCode.D) {
            movingRight = true;
        } else if (code == KeyCode.SPACE && jumps < MAX_JUMPS && rectangle.getY() == GROUND_LEVEL) {
            jump();
        }
    }

    private void handleKeyRelease(KeyCode code) {
        if (code == KeyCode.A) {
            movingLeft = false;
        } else if (code == KeyCode.D) {
            movingRight = false;
        }
    }

    private void jump() {
        jumps++;
        rectangle.setY(rectangle.getY() - 1); // Move up a bit to avoid immediate double jump
        rectangle.setY(Math.max(0, rectangle.getY())); // Ensure it's within bounds
        rectangle.setY(rectangle.getY() + 1); // Move back down

        rectangle.setY(rectangle.getY() + JUMP_VELOCITY);
    }

    @Override
    public void stop() {
        // Cleanup code here if necessary
    }

    public static void main(String[] args) {
        launch(args);
    }
}
