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
        arrayManager.createRandomArray(userInterface.getUserArrayLength());
        userInterface.readArray(arrayManager.getUnsortedIntArray());
    }
    public void sortArray() throws FetchArrayException, InterruptedException {
        userInterface.sortCountdown(arrayManager.getSortMethod());
        arrayManager.createSortMethod();
        arrayManager.sortArray();
        userInterface.displaySortTime(arrayManager.getTimeTaken(),arrayManager.getSortMethod());
        userInterface.readArray(arrayManager.getSortedIntArray());
        arrayManager.addToMethodList();
        arrayManager.addToTimeList();
        arrayManager.addToArrayList();
    }
    public boolean repeat() {
        return userInterface.repeatCheck();
    }
    public void callLeaderboards(){
        userInterface.historyCheck(arrayManager.getTimeList(),arrayManager.getMethodList(),arrayManager.getArrayList());
    }
}
