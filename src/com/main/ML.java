package com.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ML extends MouseAdapter implements MouseMotionListener {

    static ML mouseListener = null;

    public boolean isPressed = false;
    public double x ,y;

    public static ML getMouseListener(){
        if(ML.mouseListener == null){
            return new ML();
        }
        return ML.mouseListener;
    }

    @Override
    public void mouseMoved(MouseEvent event){
        x = event.getX();
        y = event.getY();
    }
    @Override
    public void mousePressed(MouseEvent event){
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
    }

    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public boolean isPressed(){return isPressed;}
}
