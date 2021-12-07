package com.scenes;

import com.entity.Rect;
import com.main.ML;
import com.main.Main;
import com.main.Window;
import com.util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuScene extends Scene {

    //Buffered Images
    public BufferedImage play,playHovered,exit ,exitHovered;
    public BufferedImage currentPlay;
    public BufferedImage currentExit;

    //Buttons
    public Rect playButton, exitButton;

    public MenuScene(){
        try {
            play = ImageIO.read(new File("assets/Play.png"));
            playHovered = ImageIO.read(new File("assets/PlayPressed.png"));
            exit = ImageIO.read(new File("assets/Exit.png"));
            exitHovered = ImageIO.read(new File("assets/ExitPressed.png"));

            playButton = new Rect(300,160,200, 100);
            exitButton = new Rect(300,260,200,100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(double deltaTime, ML mouseListener) {
        if(mouseListener.getX() >= playButton.x && mouseListener.getX() <= playButton.x + playButton.width && mouseListener.getY() >= playButton.y && mouseListener.getY() <= playButton.y + playButton.height){
            currentPlay = playHovered;
            if(mouseListener.isPressed()){
                Window.getWindow().changeScene(1);
            }
        }else {
            currentPlay = play;
        }
        if(mouseListener.getX() >= exitButton.x && mouseListener.getX() <= exitButton.x + exitButton.width && mouseListener.getY() >= exitButton.y && mouseListener.getY() <= exitButton.y + exitButton.height){
            currentExit = exitHovered;
            if(mouseListener.isPressed()){
                Window.getWindow().dispose();
                try {
                    Main.thread.join();
                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else {
            currentExit = exit;
        }
    }

    @Override
    public void draw(double deltaTime, Graphics2D graphics2D) {
        //System.out.println("Working");
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillRect(0,0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        graphics2D.drawImage(currentPlay,300,160,null);
        graphics2D.drawImage(currentExit,300,260,null);

    }
}
