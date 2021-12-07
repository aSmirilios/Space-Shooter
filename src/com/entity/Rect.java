package com.entity;

import com.main.KL;
import com.util.Constants;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Rect {

    KL keyListener = KL.getKeyListener();

    public int x,y,width,height;
    public int behavior;

    public Rect(int x , int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
    }

    public void update(double deltaTime, int behavior){
        //System.out.println(x);
        this.behavior = behavior; // I access the behavior as a class variable so that I can determine whether the rectangle is used as a collider or if it has to be shown in the screen
        switch (behavior){
            case 0: //This case is for the rectangle being a collider and the x value increases
                this.x += Constants.PLAYER_HORIZONTAL_SPEED_RIGHT*deltaTime;
                break;
            case 1: //This case is for the rectangle being a collider and the x value decreases
                this.x -= Constants.PLAYER_HORIZONTAL_SPEED_LEFT*deltaTime;
                break;
            case 2: //This case if for the rectangle being a collider for the player
                if(x >= Constants.LEFT_BOARDER_X){
                    Triangle.canMoveLeft = true;
                }
                if(x <= Constants.LEFT_BOARDER_X) {
                    Triangle.canMoveLeft = false;
                }
                if(x < Constants.SCREEN_WIDTH - (Constants.RIGHT_BOARDER_Y + width)){
                    Triangle.canMoveRight = true;
                }
                if(x >= Constants.SCREEN_WIDTH - (Constants.RIGHT_BOARDER_Y + width)){
                    Triangle.canMoveRight = false;
                    //System.out.println(Constants.SCREEN_WIDTH - Constants.RIGHT_BOARDER_Y);
                }
                break;
            case 3: //This case is for the rectangle being a collider for an asteroid
                this.y += Constants.ASTEROID_SPEED*deltaTime;
                //TODO: get the bullets
                break;

        }
    }

    public void draw(Graphics2D graphics2D){
        if(behavior != 0 && behavior != 1 && behavior != 2 && behavior!= 3) {
             graphics2D.setColor(Color.WHITE); //TODO: stop drawing the collider
             graphics2D.drawRect(x,y,width,height);
        }
    }
}
