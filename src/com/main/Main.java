package com.main;

public class Main {

    public static Thread thread;

    public static void main(String[] args) {
        Window window = Window.getWindow();
        thread = new Thread(window);
        thread.start();
    }
}
