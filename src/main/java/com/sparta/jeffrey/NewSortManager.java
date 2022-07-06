package com.sparta.jeffrey;

public class NewSortManager {
    ArrayManager arrayManager=new ArrayManager();
    UserInterface userInterface=new UserInterface();

    public void startProgram(){
        try {
            userInterface.intro();
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // to change to logger
        }
    }
    public void getUserSortMethod(){
        try {
            arrayManager.setSortMethod(userInterface.getUserMethod());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
