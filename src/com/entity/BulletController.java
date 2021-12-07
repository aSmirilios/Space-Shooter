package com.entity;

import com.main.KL;
import com.util.BulletCooldown;
import com.util.Constants;
import com.util.Time;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BulletController {

    public static boolean[] isBulletKilled = new boolean[Constants.MAX_BULLETS];

    public KL keyListener = KL.getKeyListener();
    static public Bullet[] bullets;
    static public int bulletCounter = 0;

    public BulletController(){
        bullets = new Bullet[Constants.MAX_BULLETS];
        for (int i = 0; i < isBulletKilled.length; i++) {
            isBulletKilled[i] = false;
        }
    }

    long lastSpace = 0;
    long cooldownTime = 500; //500 was the original
    public void update(double deltaTime){
        long time = System.currentTimeMillis();
        if(time > (lastSpace + cooldownTime)){
        if(keyListener.isKeyPressed(KeyEvent.VK_SPACE)) {
            if (bulletCounter <= Constants.MAX_BULLETS - 1) {
                bullets[bulletCounter] = new Bullet(Triangle.xPoints[0] - (Constants.BULLET_DIMENSIONS/2), Triangle.yPoints[0], Constants.BULLET_DIMENSIONS, Constants.BULLET_DIMENSIONS);
                isBulletKilled[bulletCounter] = false;
                BulletCooldown cooldown = new BulletCooldown();
                cooldown.cooldownTimer(bulletCounter);
                //cooldown = null; //TODO: Maybe remove this since java already handles this though garbage collection --> STATUS: DONE
                //System.out.println(bullets[bulletCounter]);
                bulletCounter++;
            } else {
                //System.out.println("...");
            }
            lastSpace = time;
        }
        }
        for (int i = 0; i < bullets.length; i++) {
            if(bullets[i] != null) {
                bullets[i].update(deltaTime);
            }
        }
    }

    public void draw(Graphics2D graphics2D){
        for (int i = 0; i < bullets.length; i++) {
            if(bullets[i] != null){
                if(isBulletKilled[i] == false) { //Only draw bullets if they are not killed
                   // System.out.println("drawing");
                    bullets[i].draw(graphics2D);
                }
            }
        }
    }

    public Bullet[] getBullets(){
        return BulletController.bullets;
    }
}
