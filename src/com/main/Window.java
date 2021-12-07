package com.main;

import com.scenes.GameOverScene;
import com.scenes.GameScene;
import com.scenes.MenuScene;
import com.scenes.Scene;
import com.util.Constants;
import com.util.Time;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;

public class Window extends JFrame implements Runnable {
    static Window window = null;

    //Global Graphics2D handle
    public static Graphics2D graphics2D_Global;

    //FPS-counter
    public static int fps;
    //Double-Buffering
    Image dbImage;
    Graphics dbg;

    //Scenes
    public static Scene currentScene;
    public boolean isRunning;

    //Listeners
    KL keyListener = KL.getKeyListener();
    ML mouseListener = ML.getMouseListener();

    int width, height;
    String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width, height);
        setTitle(title);
        setVisible(true);
        addKeyListener(keyListener);
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);
        changeScene(0);
        Constants.LEFT_BOARDER_X = this.getInsets().left + 1; //Adding a little offset to the left boarder because it is not exact
        Constants.RIGHT_BOARDER_Y = this.getInsets().right + 2; //Same here
        isRunning = true;
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);
        }
        return Window.window;
    }

    public void changeScene(int sceneIndex) {
        switch (sceneIndex) {
            case 0:
                currentScene = new MenuScene();
                break;
            case 1:
                currentScene = new GameScene();
                break;
            case 2:
                currentScene = new GameOverScene();
                break;
            default:
                System.out.println("Unknown Scene");
                currentScene = null;
                break;
        }

    }

    public void update(double deltaTime) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        draw(deltaTime, dbg);
        getGraphics().drawImage(dbImage, 0, 0, this);

        currentScene.update(deltaTime, mouseListener);

        //System.out.println(deltaTime);


    }

    public void draw(double deltaTime, Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D_Global = graphics2D;
        currentScene.draw(deltaTime, graphics2D);
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        long startTime = System.currentTimeMillis();
        while(isRunning) {
            long time = System.nanoTime();
            int delta_time = (int) ((time - lastTime) / 1E6);
            lastTime = time;
            update(delta_time);
            this.fps++;
            long now = System.currentTimeMillis();

            //FPS-COUNTER
            if(now - startTime >= 1000){
                System.out.println(fps);
                startTime += 1000;
                this.fps = 0;
            }


            try {
                Thread.sleep(14);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public static Graphics2D getGraphics2D_Global(){
        return graphics2D_Global;
    }
}


