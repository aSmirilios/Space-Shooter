package com.scenes;

import com.entity.*;
import com.main.KL;
import com.main.ML;
import com.main.Window;
import com.util.Constants;
import com.util.ScoreCounter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;

public class GameScene extends Scene{

    public KL keyListener = KL.getKeyListener();

    //public Graphics2D graphics2D;
    public Triangle player;

    public BufferedImage penalties;
    public BufferedImage zero;
    public BufferedImage one;
    public BufferedImage two;
    public BufferedImage three;

    public BufferedImage numberToShow = null;

    String penaltiesString;

    public int bulletCounter = 0;

    BulletController  bulletController;
    AsteroidsController asteroidsController;

    public GameScene(){
        penaltiesString = Integer.toString(0);
        try {
            penalties = ImageIO.read(new File("assets/Penalties.png"));
            zero = ImageIO.read(new File("assets/Zero.png"));
            one = ImageIO.read(new File("assets/One.png"));
            two = ImageIO.read(new File("assets/Two.png"));
            three = ImageIO.read(new File("assets/Three.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        player = new Triangle(Constants.PLAYER_X_POINTS,Constants.PLAYER_Y_POINTS);
        bulletController = new BulletController();
        asteroidsController = new AsteroidsController();
    }

    @Override
    public void update(double deltaTime, ML mouseListener) {
        if(ScoreCounter.penalties == 0){
            numberToShow = zero;
        }
        if(ScoreCounter.penalties == 100){
            numberToShow = one;
        }
        if(ScoreCounter.penalties == 200){
            numberToShow = two;
        }
        if(ScoreCounter.penalties >= 300) {
            numberToShow = three;
            Window.getWindow().changeScene(2);
        }
        player.update(deltaTime);
        bulletController.update(deltaTime);
        asteroidsController.update(deltaTime);
    }

    @Override
    public void draw(double deltaTime, Graphics2D graphics2D) {
        //Backround
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0, Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        graphics2D.drawImage(penalties, Constants.LEFT_BOARDER_X, 40, null);
        graphics2D.drawImage(numberToShow, Constants.LEFT_BOARDER_X + penalties.getWidth() + 10, 32 + (penalties.getHeight()/2), null);
       // graphics2D.drawString(penaltiesString, Constants.LEFT_BOARDER_X + penalties.getWidth() + 20, 40 + (penalties.getHeight()/2));
        System.out.println(ScoreCounter.penalties);
        player.draw(graphics2D);
        bulletController.draw(graphics2D);
        asteroidsController.draw(graphics2D);
    }

}
