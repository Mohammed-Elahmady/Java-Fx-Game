package com.example.project;

//import javafx.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class Project1 extends Application
{

    /*Start*/
    public static void main(String[] args)
    {
        launch(args);
    }

    ///////////////// Project Prameters /////////////////

    /*   Screen Resilution
     *   X = 0 : 1465
     *   Y = 0 : 745
     *   */


    ///////////////// FULL Screen Scene /////////////////
    double X = 1465;
    double Y = 745;

    ///////////////// Main Character /////////////////
    private Rectangle R1;
    private double R1_W = 70;
    private double R1_H = 90;
    private double R1_X = R1_W;
    private double R1_Y = Y-R1_H;

    private boolean Move_R = false;
    private boolean Move_L = false;
    private boolean jump = false;
    private double jump_Velocity = 0;

    private boolean Shoots = true;

    ///////////////// Boss Character /////////////////

    private Rectangle R2;
    private double R2_W = 70;
    private double R2_H = 90;
    private double R2_X = X - R2_W;
    private double R2_Y = Y-R2_H;

    ///////////////// Ground Level /////////////////

    double Ground = 745-90;

    ///////////////// Health Level /////////////////

    private Image H1;
    private Image H2;
    private Image H3;
    private ImageView H11;
    private ImageView H22;
    private ImageView H33;

    ///////////////// Scene /////////////////
    @Override
    public void start(Stage primaryStage)
    {

        ///////////////// Characters impelmentation /////////////////

        R1 = new Rectangle(R1_X,R1_Y,R1_W,R1_H);
        R2 = new Rectangle(R2_X,R2_Y,R2_W,R2_H);
        R1.setFill(Color.BLUE);
        R2.setFill(Color.RED);

        ///////////////// Main Pane /////////////////

        Pane pane = new Pane(R1,R2/*,H11,H22,H33*/);
        Scene scene = new Scene(pane,600,400);
        pane.setPadding(new Insets(50));
        primaryStage.setScene(scene);
        primaryStage.show();


        ///////////////// Characters Health Bar /////////////////



        ///////////////// Main Character Movement /////////////////
        scene.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.D)
            {
                Move_R = true;
            }
            else if (e.getCode() == KeyCode.A)
            {
                Move_L = true;
            }
            else if (e.getCode() == KeyCode.SPACE && !jump)
            {
                jump = true;
            }
            else if (e.getCode() == KeyCode.K)
            {
                Shoots = true;
            }
        });
        scene.setOnKeyReleased(e->{
            if (e.getCode() == KeyCode.D)
            {
                Move_R = false;
            }
            else if (e.getCode() == KeyCode.A)
            {
                Move_L = false;
            }
            else if (e.getCode() == KeyCode.K)
            {
                Shoots = false;
            }
        });



        ///////////////// Main Character Animation /////////////////
         new AnimationTimer() {
            @Override
            public void handle(long now) {
                //////////// Move ///////////
                if (Move_R && R1.getX() < X - R1.getWidth())
                {
                    R1.setX(R1.getX()+5);
                }
                if(Move_L && R1.getX() > R1.getWidth())
                {
                    R1.setX(R1.getX()-5);
                }
                if(jump)
                {
                    jump_Velocity = 10;
                    jump = false;
                }
                //////////// Gravitiy ///////////
                jump_Velocity-=0.5;
                R1.setY(R1.getY() - jump_Velocity);
                if (R1.getY() >= R1_Y )
                {
                    R1.setY(R1_Y);
                    jump_Velocity = 0;
                }
                if (R1.getY() <= Y - R1_H - 200 )
                {
                    R1.setY(R1_Y);
                }
                //////////// Shooting ///////////
                if (Shoots)
                {
                    Rectangle R = new Rectangle(R1_X,R1_Y,10,5);
                    R.setFill(Color.RED);
                }

            }
        }.start();


        ///////////////// Boss Character Movement /////////////////


        ///////////////// Boss Character Animation /////////////////


}
}
