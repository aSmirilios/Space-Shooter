package com.util;

public class Constants {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final String SCREEN_TITLE = "Space-Shooter";

    //PlayerSpeed
    public static final double PLAYER_HORIZONTAL_SPEED_LEFT = 0.5d;
    public static final double PLAYER_HORIZONTAL_SPEED_RIGHT = 1.5*PLAYER_HORIZONTAL_SPEED_LEFT;
    //Player-Dimension
    public static final int[] PLAYER_X_POINTS = {400,420,380};
    public static final int[] PLAYER_Y_POINTS = {530,580,580};
    public static final int PLAYER_SIDES = 3;
    //Bullet-Constants
    public static final int BULLET_SPEED = 1;
    public static final int MAX_BULLETS = 100;//15
    public static final int BULLET_DIMENSIONS = 10;
    //Boarders
    public static int LEFT_BOARDER_X;
    public static int RIGHT_BOARDER_Y;
    //Asteroids-Constants
    public static final int[] LARGE_ASTEROID_XPOINTS = {400, 340, 340 , 390, 450};
    public static final int[] LARGE_ASTEROID_YPOINTS = {0,20,80,95,70};
    public static final int[] MEDIUM_ASTEROID_XPOINTS = {400,370,370,390,420};
    public static final int[] MEDIUM_ASTEROID_YPOINTS = {0,10,30,65,50};
    public static final int[] SMALL_ASTEROID_XPOINTS = {400,360,360,390,420};
    public static final int[] SMALL_ASTEROID_YPOINTS = {0,10,30,40,40};
    public static final int MAX_ASTEROIDS = 4; //Was 10
    public static final float ASTEROID_SPEED = 0.1f;

}
