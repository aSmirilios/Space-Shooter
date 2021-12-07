package com.util;

public class Time {
    static double startTime = System.nanoTime();
    public static double getTime(){
        return (System.nanoTime() - startTime) * 1E-9;
    }
}
