package com.scenes;

import com.main.ML;
import com.util.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameOverScene extends Scene{

    public BufferedImage gameOver;

    public GameOverScene(){
        try {
            gameOver = ImageIO.read(new File("assets/GameOver.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(double deltaTime, ML mouseListener) {

    }

    @Override
    public void draw(double deltaTime, Graphics2D graphics2D) {

        graphics2D.setColor(Color.darkGray);
        graphics2D.fillRect(0,0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        graphics2D.drawImage(gameOver, 300, 250, null);
    }
}
