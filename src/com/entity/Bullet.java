package com.entity;

import java.awt.*;

public class Bullet {


    
    Rect bulletRectangle;
    int x,y,width,height; //TODO: use this to check collisions though the asteroid Class

    public Bullet(int x, int y,int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(double deltaTime){
       // System.out.printf("updating");
        this.y -= 1*deltaTime;
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(x,y,width,height);
    }
}
