package com.util;

import com.entity.Bullet;
import com.entity.BulletController;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class BulletCooldown {

    public void cooldownTimer(int bulletCounter) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = 10;
            @Override
            public void run() {
                if(counter > 0){
                    //System.out.println(counter + "seconds"); // This is the bullet cooldown counter
                    counter--;
                }else {
                    BulletController.bullets[bulletCounter] = null;
                    //System.out.println("killed a bullet"); // This is an indication that the instantiated bullet has been killed
                    BulletController.bulletCounter--;
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
