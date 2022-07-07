package com.sparta.jeffrey.sortmanager.model.utilities;

public class Timer {
    private long startTime=0;
    public void start(){
        startTime=System.nanoTime();
    }
    public double getCurrentMilliseconds(){
        return (System.nanoTime()-startTime)/1E6;
    }
}
