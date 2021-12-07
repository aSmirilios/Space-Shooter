package com.entity;

import com.main.KL;
import com.main.ML;
import com.main.Window;
import com.scenes.GameScene;
import com.util.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Triangle{


    //TODO: ADD COLLISIONS WITH THE BORDERS OF THE SCREEN


    public Graphics2D graphics2D = Window.getGraphics2D_Global();

    public GameScene gameScene;
    public KL keyListener = KL.getKeyListener();

    Polygon player;
    Rect boxCollider;

    public static int xPoints[];
    public static int yPoints[];

    public static boolean canMoveLeft = true;
    public static boolean canMoveRight = true;

    public Triangle(int xPoints[], int yPoints[]){
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        player = new Polygon(xPoints,yPoints,Constants.PLAYER_SIDES);
        boxCollider = new Rect(xPoints[0] - (xPoints[0] - xPoints[2]), yPoints[0], xPoints[1] - xPoints[2],yPoints[1] - yPoints[0]);
        //boxCollider = new Rect(380,530,40,50);
    }

    public void update(double deltaTime){
        //System.out.println(1/deltaTime);
        boxCollider.update(deltaTime, 2);
                if(canMoveRight) {
                    if (keyListener.isKeyPressed(KeyEvent.VK_RIGHT)) { //TODO: Fix the difference of speed when pressing right compered to pressing left(for now i hard code the estimated speed difference)//
                        xPoints[0] += Constants.PLAYER_HORIZONTAL_SPEED_RIGHT * deltaTime;
                        xPoints[1] += Constants.PLAYER_HORIZONTAL_SPEED_RIGHT * deltaTime;
                        xPoints[2] += Constants.PLAYER_HORIZONTAL_SPEED_RIGHT * deltaTime;
                        boxCollider.update(deltaTime, 0);

                    }
                }
                if(canMoveLeft) {
                    if (keyListener.isKeyPressed(KeyEvent.VK_LEFT)) {
                        xPoints[0] -= Constants.PLAYER_HORIZONTAL_SPEED_LEFT * deltaTime;
                        xPoints[1] -= Constants.PLAYER_HORIZONTAL_SPEED_LEFT * deltaTime;
                        xPoints[2] -= Constants.PLAYER_HORIZONTAL_SPEED_LEFT * deltaTime;
                        boxCollider.update(deltaTime, 1);
                    }
                }
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawPolygon(xPoints,yPoints,xPoints.length);
        boxCollider.draw(graphics2D);
    }

    public void checkCollisions(){

    }
}
