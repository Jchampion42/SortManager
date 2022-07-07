package com.sparta.jeffrey.sortmanager.view;

import com.sparta.jeffrey.sortmanager.model.ArrayUtilities;
import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    public void intro() throws InterruptedException {
        System.out.println("Welcome to the array sorting program!\n");
        Thread.sleep(750); // delays to improve user experience
        System.out.println("In this program we will be sorting an array of integers.\n");
        Thread.sleep(750); // delays to improve user experience
        }

    public SortMethodEnum getUserMethod() throws InterruptedException {
        SortMethodEnum sortMethod;
        System.out.println("Please select a sort method to use by typing its number:");
        for (SortMethodEnum s : SortMethodEnum.values()){ // prints a list to the user of all enums in the list representing the different sort methods
            System.out.println(s.getSortKey()+ ". " +s.getSortMethod());
        }

        sortMethod= UserChoiceModule.getUserEnum(); // selection module to return an enum for storage related to the list available

        System.out.println("\nMethod selected: " + sortMethod.getSortMethod());
        Thread.sleep(750);
        return  sortMethod;
    }
    public int getUserArrayLength(){
        int arrayLength;
        arrayLength= UserChoiceModule.getUserArrayLength(); // selection module to obtain a length of value 1 or greater
        System.out.println("Generating array of length " + arrayLength);
        return arrayLength;
    }
    public void readArray(int[] arrayToRead) throws InterruptedException {
        List<Integer> listToSort=new ArrayList<>();
        for (int i : arrayToRead){
            listToSort.add(i);
        }

        System.out.println("Array layout:");

        ArrayUtilities.readArray(listToSort); // array utilities function to read out an array
        Thread.sleep(1500);
    }
    public void sortCountdown(SortMethodEnum sortMethod) throws InterruptedException {
        System.out.println("Sorting using " + sortMethod.getSortMethod() + " in ");
        for (int i=3 ;i>0 ; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
    public void displaySortTime(double time, SortMethodEnum sortMethod) throws InterruptedException {
        System.out.println(sortMethod.getSortMethod() + " took " + time + " milliseconds to sort the array\n");
        Thread.sleep(2000);
    }
}
