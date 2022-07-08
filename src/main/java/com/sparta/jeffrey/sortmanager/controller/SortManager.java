package com.sparta.jeffrey.sortmanager.controller;

import com.sparta.jeffrey.sortmanager.core.FetchArrayException;
import com.sparta.jeffrey.sortmanager.model.utilities.Timer;
import com.sparta.jeffrey.sortmanager.model.ArrayManager;
import com.sparta.jeffrey.sortmanager.view.UserInterface;

public class SortManager {
    ArrayManager arrayManager=new ArrayManager();
    UserInterface userInterface=new UserInterface();

    public void startProgram() throws InterruptedException {
            userInterface.intro();
    }
    public void getUserSortMethod() throws InterruptedException {
            arrayManager.setSortMethod(userInterface.getUserMethod());
    }
    public void generateUserArray() throws FetchArrayException, InterruptedException {
        arrayManager.createRandomArray(userInterface.getUserArrayLength()); //creation of array in array manager
        userInterface.readArray(arrayManager.getUnsortedIntArray()); // passing of array back to viewer
    }
    public void sortArray() throws FetchArrayException, InterruptedException {
        userInterface.sortCountdown(arrayManager.getSortMethod()); // 3..2..1..
        arrayManager.createSortMethod(); // initialise sort to use
        arrayManager.sortArray();   // perform sort
        userInterface.displaySortTime(arrayManager.getTimeTaken(),arrayManager.getSortMethod()); // passes method and time to view
        userInterface.readArray(arrayManager.getSortedIntArray());// pass sorted array to viewer to read
        arrayManager.addToMethodList(); // commit method for leaderboard
        arrayManager.addToTimeList();   // commit time for leaderboard
        arrayManager.addToArrayList();  // commit array length for leaderboard
    }
    public boolean repeat() {
        return userInterface.repeatCheck();
    }
    public void callLeaderboards(){
        userInterface.historyCheck(arrayManager.getTimeList(),arrayManager.getMethodList(),arrayManager.getArrayList()); // gets current list of stored values for leaderboard
    }
}
