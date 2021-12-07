package com.scenes;

import com.main.ML;

import java.awt.Graphics2D;;

public abstract class Scene {

    public abstract void update(double deltaTime, ML mouseListener);
    public abstract void draw(double deltaTime, Graphics2D graphics2D);
}
