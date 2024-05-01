package com.example.project;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;


public class Project extends Application
{

    /*Start*/
    public static void main(String[] args)
    {
        launch(args);
    }

    ///////////////// Project Prameters /////////////////

    /*   Screen Resolution
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


    ///////////////// Boss Character /////////////////

    private Rectangle R2;
    private double R2_W = 70;
    private double R2_H = 90;
    private double R2_X = X - R2_W;
    private double R2_Y = Y-R2_H;

    private double R2_MoveX = 6.5;
    private double R2_MoveY = 10;
    private Random random =new Random();

    ///////////////// Ground Level /////////////////

    double Ground = Y-R1_H;

    ///////////////// Health Level "3nab" /////////////////

    private InputStream IS1;
    private InputStream IS2;
    private InputStream IS3;
    private InputStream IS4;
    private InputStream IS5;
    private InputStream IS6;

    private Image IM1;
    private Image IM2;
    private Image IM3;
    private Image IM4;
    private Image IM5;
    private Image IM6;

    private ImageView IV1;
    private ImageView IV2;
    private ImageView IV3;
    private ImageView IV4;
    private ImageView IV5;
    private ImageView IV6;

    private double IV_1_4_X = 70;
    private double IV_2_5_X = 115;
    private double IV_3_6_X = 160;
    private double IVY = 55 ;
    private double IVW = 40 ;
    private double IVH = 50 ;

    ///////////////// Health Level "Villain" /////////////////
    private InputStream IS00;
    private InputStream IS10;
    private InputStream IS20;
    private InputStream IS30;
    private InputStream IS40;
    private InputStream IS50;
    private InputStream IS60;
    private InputStream IS70;
    private InputStream IS80;

    private Image IM00;
    private Image IM10;
    private Image IM20;
    private Image IM30;
    private Image IM40;
    private Image IM50;
    private Image IM60;
    private Image IM70;
    private Image IM80;

    private ImageView IV00;
    private ImageView IV10;
    private ImageView IV20;
    private ImageView IV30;
    private ImageView IV40;
    private ImageView IV50;
    private ImageView IV60;
    private ImageView IV70;
    private ImageView IV80;

    private double IVX_Boss = 1190;
    private double IVY_Boss = 0;
    private double IVW_Boss = 500;
    private double IVH_Boss = 300;

    ///////////////// Scene /////////////////
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException {

        ///////////////// Characters impelmentation /////////////////

        R1 = new Rectangle(R1_X,Ground,R1_W,R1_H);
        R2 = new Rectangle(R2_X,Ground,R2_W,R2_H);
        R1.setFill(Color.BLUE);
        R2.setFill(Color.RED);

        ///////////////// 3nab Health Bar /////////////////

        IS1 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\heart background.png");
        IM1 = new Image(IS1);
        IV1 = new ImageView(IM1);
        IV1.setFitHeight(IVH);
        IV1.setFitWidth(IVW);
        IV1.setX(IV_1_4_X);
        IV1.setY(IVY);

        IS2 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\heart background.png");
        IM2 = new Image(IS2);
        IV2 = new ImageView(IM2);
        IV2.setFitHeight(IVH);
        IV2.setFitWidth(IVW);
        IV2.setX(IV_2_5_X);
        IV2.setY(IVY);

        IS3 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\heart background.png");
        IM3 = new Image(IS3);
        IV3 = new ImageView(IM3);
        IV3.setFitHeight(IVH);
        IV3.setFitWidth(IVW);
        IV3.setX(IV_3_6_X);
        IV3.setY(IVY);

        IS4 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\heart.png");
        IM4 = new Image(IS4);
        IV4 = new ImageView(IM4);
        IV4.setFitHeight(IVH);
        IV4.setFitWidth(IVW);
        IV4.setX(IV_1_4_X);
        IV4.setY(IVY);

        IS5 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\heart.png");
        IM5 = new Image(IS5);
        IV5 = new ImageView(IM5);
        IV5.setFitHeight(IVH);
        IV5.setFitWidth(IVW);
        IV5.setX(IV_2_5_X);
        IV5.setY(IVY);

        IS6 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\heart.png");
        IM6 = new Image(IS6);
        IV6 = new ImageView(IM6);
        IV6.setFitHeight(IVH);
        IV6.setFitWidth(IVW);
        IV6.setX(IV_3_6_X);
        IV6.setY(IVY);

        ///////////////// Villain Health Bar /////////////////

        IS00 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\00.png");
        IM00 = new Image(IS00);
        IV00 = new ImageView(IM00);
        IV00.setFitWidth(IVW_Boss);
        IV00.setFitHeight(IVH_Boss);
        IV00.setX(IVX_Boss);
        IV00.setY(IVY_Boss);

        IS10 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\10.png");
        IM10 = new Image(IS10);
        IV10 = new ImageView(IM10);
        IV10.setFitWidth(IVW_Boss);
        IV10.setFitHeight(IVH_Boss);
        IV10.setX(IVX_Boss);
        IV10.setY(IVY_Boss);

        IS20 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\20.png");
        IM20 = new Image(IS20);
        IV20 = new ImageView(IM20);
        IV20.setFitWidth(IVW_Boss);
        IV20.setFitHeight(IVH_Boss);
        IV20.setX(IVX_Boss);
        IV20.setY(IVY_Boss);

        IS30 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\30.png");
        IM30 = new Image(IS30);
        IV30 = new ImageView(IM30);
        IV30.setFitWidth(IVW_Boss);
        IV30.setFitHeight(IVH_Boss);
        IV30.setX(IVX_Boss);
        IV30.setY(IVY_Boss);

        IS40 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\40.png");
        IM40 = new Image(IS40);
        IV40 = new ImageView(IM40);
        IV40.setFitWidth(IVW_Boss);
        IV40.setFitHeight(IVH_Boss);
        IV40.setX(IVX_Boss);
        IV40.setY(IVY_Boss);

        IS50 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\50.png");
        IM50 = new Image(IS50);
        IV50 = new ImageView(IM50);
        IV50.setFitWidth(IVW_Boss);
        IV50.setFitHeight(IVH_Boss);
        IV50.setX(IVX_Boss);
        IV50.setY(IVY_Boss);

        IS60 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\60.png");
        IM60 = new Image(IS60);
        IV60 = new ImageView(IM60);
        IV60.setFitWidth(IVW_Boss);
        IV60.setFitHeight(IVH_Boss);
        IV60.setX(IVX_Boss);
        IV60.setY(IVY_Boss);

        IS70 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\70.png");
        IM70 = new Image(IS70);
        IV70 = new ImageView(IM70);
        IV70.setFitWidth(IVW_Boss);
        IV70.setFitHeight(IVH_Boss);
        IV70.setX(IVX_Boss);
        IV70.setY(IVY_Boss);

        IS80 = new FileInputStream("D:\\Problems\\JavaFX\\PROJECT\\src\\main\\java\\com\\example\\project\\Health_Bar\\80.png");
        IM80 = new Image(IS80);
        IV80 = new ImageView(IM80);
        IV80.setFitWidth(IVW_Boss);
        IV80.setFitHeight(IVH_Boss);
        IV80.setX(IVX_Boss);
        IV80.setY(IVY_Boss);

        ///////////////// Main Pane /////////////////

        Pane pane = new Pane(R1,R2 ,IV1,IV2,IV3,IV4,IV5,IV6,IV00,IV10,IV20,IV30,IV40,IV50,IV60,IV70,IV80);
        Scene scene = new Scene(pane,600,400);
        pane.setPadding(new Insets(50));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("The Amazing 3nab Man");

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
        });

        ///////////////// 3nab Animation /////////////////

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                Moving_Right();
                Moving_Left();
                Jumping();
                Gravity();

            }}.start();



        ///////////////// Boss Character Animation /////////////////
        AnimationTimer T1 = new AnimationTimer()
        {
            @Override
            public void handle (long now)
            {

                VillainMovement();

                Villian_Jump();

            }
        };
        T1.start();

    }

    //////////// 3nab Move Methods ///////////
    public void Moving_Right()
    {
        if (Move_R && R1.getX() < X - R2.getWidth())
        {
            R1.setX(R1.getX()+5);
        }
    }
    public void Moving_Left()
    {
        if(Move_L && R1.getX() >R1.getWidth())
        {
            R1.setX(R1.getX()-5);
        }
    }
    //////////// 3nab Jump Method ///////////
    public void Jumping()
    {
        if(jump)
        {
            jump_Velocity = 10;
            jump = false;
        }
    }
    //////////// 3nab Gravitiy Method ///////////
    public void Gravity()
    {
        jump_Velocity-=0.5;

        R1.setY(R1.getY() - jump_Velocity);
        if (R1.getY() >= Ground) {
            R1.setY(Ground);
            jump_Velocity = 0;
        }
        jump_Velocity-=0.09;
        if (R1.getY() == 500)
        {
            R1.setY(Ground);
            jump_Velocity = 0;
        }
    }
    //////////// Villain Move Methods ///////////
    public void VillainMovement()
    {
        R2_X += R2_MoveX;
        R2_Y += R2_MoveY;

        if (R2.getX() >= 70)
        {
            R2.setX(R2.getX() - R2_MoveX);
            if (R2.getX() <= 70)
            {
                R2_MoveX *=-1;
                R2.setX(R2.getX() - R2_MoveX);
            }
            if (R2.getX() >= X-50)
            {
                R2_MoveX *=-1;
                R2.setX(R2.getX() - R2_MoveX);
            }
        }

    }
    public void Villian_Jump()
    {

        if (R2.getX() <= 500)
        {
            R2_MoveY -= 0.5;
            R2.setY(R2.getY() - R2_MoveY);
            if (R2.getY() >= Ground) {
                R2.setY(Ground);
                R2_MoveY = 0;
            }
        }
    }
}

