package com.sparta.jeffrey;

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
        Timer timer=new Timer();
        arrayManager.createSortMethod();
        timer.start();
        arrayManager.sortArray();
        userInterface.displaySortTime(timer.getCurrentMilliseconds(),arrayManager.getSortMethod());
        userInterface.readArray(arrayManager.getSortedIntArray());
    }
}
