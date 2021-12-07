package com.entity;

import com.util.Constants;
import com.util.ScoreCounter;

import java.awt.*;

public class Asteroid {

    public boolean isKilled = false;

    public Polygon asteroidPolygon;

    Rect boxCollider;
    //Unknown constants
    Color color;
    int hp;
    int[] finalXPoints;
    int[] finalYPoints;
    int xOffset,yOffset;
    int index;
    //Known constants
    int sides = 5;

    public Asteroid(int xOffset, int yOffset, int index){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.index = index;
        finalXPoints = new int[5];
        finalYPoints = new int[5];
        if(index == 0) { //Large-Asteroid
            for (int i = 0; i < Constants.LARGE_ASTEROID_XPOINTS.length; i++) {
                finalXPoints[i] = Constants.LARGE_ASTEROID_XPOINTS[i] + xOffset;
                finalYPoints[i] = Constants.LARGE_ASTEROID_YPOINTS[i] + yOffset;
                color = Color.RED;
            }
        }
        if(index == 1) { //Medium-Asteroid
            for (int i = 0; i < Constants.MEDIUM_ASTEROID_XPOINTS.length; i++) {
                finalXPoints[i] = Constants.MEDIUM_ASTEROID_XPOINTS[i] + xOffset;
                finalYPoints[i] = Constants.MEDIUM_ASTEROID_YPOINTS[i] + yOffset;
                color = Color.BLUE;
            }
        }
        if(index == 2) { //Small-Asteroid
            for (int i = 0; i < Constants.SMALL_ASTEROID_XPOINTS.length; i++) {
                finalXPoints[i] = Constants.SMALL_ASTEROID_XPOINTS[i] + xOffset;
                finalYPoints[i] = Constants.SMALL_ASTEROID_YPOINTS[i] + yOffset;
                color = Color.WHITE;
            }
        }
        switch (index){
            case 0: // In this case we want to get a large asteroid
                asteroidPolygon = new Polygon(finalXPoints,finalYPoints,sides);
                boxCollider = new Rect(finalXPoints[0] - (finalXPoints[0] - finalXPoints[1]), finalYPoints[1] - (finalYPoints[1] - finalYPoints[0]), finalXPoints[4] - finalXPoints[1], finalYPoints[3] - finalYPoints[0]);
                hp = 3;
                break;
            case 1: // In this case we want to get a medium asteroid
                asteroidPolygon = new Polygon(finalXPoints,finalYPoints,sides);
                boxCollider = new Rect(finalXPoints[0] - (finalXPoints[0] - finalXPoints[1]), finalYPoints[1] - (finalYPoints[1] - finalYPoints[0]), finalXPoints[4] - finalXPoints[1], finalYPoints[3] - finalYPoints[0]);
                hp = 2;
                break;
            case 2: // In this case we want to get a small asteroid
                asteroidPolygon = new Polygon(finalXPoints,finalYPoints,sides);
                boxCollider = new Rect(finalXPoints[0] - (finalXPoints[0] - finalXPoints[1]), finalYPoints[1] - (finalYPoints[1] - finalYPoints[0]), finalXPoints[4] - finalXPoints[1], finalYPoints[3] - finalYPoints[0]);
                hp = 1;
                break;
            default:
                System.out.println("Not a valid index");
        }


    }

    public void update(double deltaTime){
        System.out.println();
        for (int i = 0; i < sides; i++) { //Updating polygon's yPoints
            asteroidPolygon.ypoints[i] += Constants.ASTEROID_SPEED*deltaTime;
        }
        for (int i = 0; i < Constants.MAX_BULLETS; i++) {
            if(BulletController.bullets[i] != null && BulletController.isBulletKilled[i] != true && isKilled == false && BulletController.bullets[i].y <= (boxCollider.y + boxCollider.height) && BulletController.bullets[i].x >= boxCollider.x && BulletController.bullets[i].x <= (boxCollider.x + boxCollider.width)){
                //System.out.println("Collision");
                BulletController.isBulletKilled[i] = true; //TODO --> !!!IMPORTANT!!! <-- NOW BECAUSE I AM NOT DESTROYING THE ASTEROIDS, WHEN THEY MOVE BELLOW THE SCREEN HEIGHT THERE IS CONFLICT ON THE COLLISION CHECKING WITH THE BULLETS BUT THIS IS GOING TO BE FIXED ONCE I ADD A "KILL" FUNCTIONALITY FOR THE ASTEROIDS
                hp--;
                if(hp <= 0) {
                    isKilled = true;
                }
            }
            if(boxCollider.y >= Constants.SCREEN_HEIGHT - boxCollider.height){ //Killing the asteroid if it has reached the bottom of the screen
                isKilled = true;
                ScoreCounter.penalties++;

            }
        }
            boxCollider.update(deltaTime, 3);

    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.drawPolygon(asteroidPolygon);
        boxCollider.draw(graphics2D);

    }
}
