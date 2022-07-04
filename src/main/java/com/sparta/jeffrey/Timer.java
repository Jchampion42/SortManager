package com.sparta.jeffrey;

public class Timer {
    long startTime=0;
    public void start(){
        startTime=System.nanoTime();
    }
    public double getCurrentMilliseconds(){
        return (System.nanoTime()-startTime)/1E6;
    }
}
