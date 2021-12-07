package com.entity;

import com.util.Constants;

import java.awt.*;
import java.util.Random;

public class AsteroidsController {

    public static Asteroid[] asteroids;
    //public int asteroidCounter;

    public AsteroidsController(){
      //  asteroidCounter = 0;
        asteroids = new Asteroid[Constants.MAX_ASTEROIDS];
    }

    long lastSpawn = 0;
    long cooldownTime = 1000000000;

    public void update(double deltaTime){
        Random rnd = new Random();
        Random asteroidIndexRnd = new Random();
        Random indexRnd = new Random();
        // This variable gives a random index to the Asteroid constructor
        int asteroidIndexRandom = asteroidIndexRnd.nextInt(0, 3);
        //System.out.println(indexRandom);
        long time = System.currentTimeMillis();
        //Spawn cooldown
        // TODO: Use indexRandom to pick a random index for the Asteroid constructor --> STATUS == DONE
        // TODO: Add a cooldown for every asteroid spawn and add condition to kill an asteroid --> STATUS = DONE
              // Adding a cooldown timer so that asteroids do not intersect
                    for (int i = 0; i < Constants.MAX_ASTEROIDS; i++) {
                        int indexRandom = indexRnd.nextInt(0,3);
                        int offSetMultiplier = rnd.nextInt(Constants.SCREEN_WIDTH + Constants.LEFT_BOARDER_X - (Constants.LARGE_ASTEROID_XPOINTS[4] - Constants.LARGE_ASTEROID_XPOINTS[1]) - Constants.RIGHT_BOARDER_Y);
                       // System.out.println(indexRandom);
                  //After debugging i have found our that the cooldown is too large and this if statement never runs
                            if (indexRandom == 0) {
                                if (asteroids[i] == null) {
                                    asteroids[i] = new Asteroid((-Constants.LARGE_ASTEROID_XPOINTS[1] + Constants.LEFT_BOARDER_X + 1) + offSetMultiplier, -12, 0);
                                    System.out.println("Spawning_Large");
                                }
                            }
                            if (indexRandom == 1) {
                                if (asteroids[i] == null) {
                                    asteroids[i] = new Asteroid((-Constants.MEDIUM_ASTEROID_XPOINTS[1] + Constants.LEFT_BOARDER_X + 1) + offSetMultiplier, -12, 1);
                                    System.out.println("Spawning_Medium");
                                }
                            }
                            if (indexRandom == 2) {
                                if (asteroids[i] == null) {
                                    asteroids[i] = new Asteroid((-Constants.SMALL_ASTEROID_XPOINTS[1] + Constants.LEFT_BOARDER_X + 1) + offSetMultiplier, -12, 2);
                                    System.out.println("Spawning_Small");
                                }
                            }
                        if(asteroids[i] != null){
                            asteroids[i].update(deltaTime);
                            if (asteroids[i].isKilled == true) {
                                asteroids[i] = null;//Free a space for a new asteroid to take its place TODO: FIX THE BUG WHERE WHEN I KILL AN ASTEROID ONE MORE GETS KILLED
                                //System.out.println("killed an asteroid");
                            }
                        }
                    }

        //Updating all the existing asteroids and checking if an asteroid is killed

    }
    public void draw(Graphics2D graphics2D){
        //Drawing all the existing asteroids
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] != null){
                asteroids[i].draw(graphics2D);
            }
        }
    }
}
