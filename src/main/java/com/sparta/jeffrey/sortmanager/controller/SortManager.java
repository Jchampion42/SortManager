package com.sparta.jeffrey.sortmanager.controller;

import com.sparta.jeffrey.sortmanager.core.FetchArrayException;
import com.sparta.jeffrey.sortmanager.model.ArrayManager;
import com.sparta.jeffrey.sortmanager.view.DisplayManager;

public class SortManager {
    ArrayManager arrayManager=new ArrayManager();
    DisplayManager displayManager =new DisplayManager();

    public void startProgram() throws InterruptedException {
            displayManager.intro();
    }
    public void getUserSortMethod() throws InterruptedException {
            arrayManager.setSortMethod(displayManager.getUserMethod());
    }
    public void generateUserArray() throws FetchArrayException, InterruptedException {
        arrayManager.createRandomArray(displayManager.getUserArrayLength()); //creation of array in array manager
        displayManager.readArray(arrayManager.getUnsortedIntArray()); // passing of array back to viewer
    }
    public void sortArray() throws FetchArrayException, InterruptedException {
        displayManager.sortCountdown(arrayManager.getSortMethod()); // 3..2..1..
        arrayManager.createSortMethod(); // initialise sort to use
        arrayManager.sortArray();   // perform sort
        displayManager.displaySortTime(arrayManager.getTimeTaken(),arrayManager.getSortMethod()); // passes method and time to view
        displayManager.readArray(arrayManager.getSortedIntArray());// pass sorted array to viewer to read
        arrayManager.addToMethodList(); // commit method for leaderboard
        arrayManager.addToTimeList();   // commit time for leaderboard
        arrayManager.addToArrayList();  // commit array length for leaderboard
    }
    public boolean repeat() {
        return displayManager.repeatCheck();
    }
    public void callLeaderboards(){
        displayManager.historyCheck(arrayManager.getTimeList(),arrayManager.getMethodList(),arrayManager.getArrayList()); // gets current list of stored values for leaderboard
    }
}
