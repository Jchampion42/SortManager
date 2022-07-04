package com.sparta.jeffrey;

import java.util.Arrays;
import java.util.List;

/*
You will be building a program that will allow a user to sort a randomised array.
The general flow of the application is:
The user is presented with a number of sort algorithms to choose from.
Decision is given via the command line (using Scanner).
The program will then ask for the length of an array again via the command line.

The program should then output:
The unsorted randomly generated array
The sort algorithm to be used
The sorted array after the algorithm has been executed
The time taken

You are required to test both the functionality of the program and the performance of the algorithms (speed tests)

Suggested Project Phases.
Phase 1
Write a program which will take an array of ints and sort it using a bubble sort algorithm.
Include JUnit tests for this and all subsequent phases (and all subsequent projects for the rest of time)
Phase 2
Take two sorted arrays as input and combine them into one sorted array.


long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(arrayToSort);
        long end = System.nanoTime();
        printAfterSort(sortedArray, end-start);
        */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Initialisation of variables---------------------------------------
        SortMethodEnum sortMethod= SortMethodEnum.BUBBLESORT;

        System.out.println("Welcome to the array sorting program!\n");
        Thread.sleep(750); // delays to improve user experience
        System.out.println("In this program we will be sorting an array of integers.\n");
        Thread.sleep(750); // delays to improve user experience
        System.out.println("First, select a method to use by typing its number:");
        for (SortMethodEnum s : SortMethodEnum.values()){
            System.out.println(s.getSortKey()+ ". " +s.getSortMethod());
        }

        //obtain desired sort algorithm--------------------------------------
        sortMethod=UserChoiceModule.getUserEnum();


        System.out.println("\nInitializing " + sortMethod.getSortMethod());
        Thread.sleep(750);

        //obtain desired length of array to sort-----------------------------
        int arrayLength;
        arrayLength= UserChoiceModule.getUserArrayLength();

        List <Integer> listToSort= ArrayUtilities.makeRandomIntArray(arrayLength);
        System.out.println("The original array layout:");

        // readout of initial array -----------------------------------------
        ArrayUtilities.readArray(listToSort);
        Thread.sleep(1000);
        System.out.println("Sorting using " + sortMethod.getSortMethod() + " in ");
        for (int i=3 ;i>0 ; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        // coverts list to array
        int[] arrayToSort = listToSort.stream().mapToInt(i->i).toArray();
        // more initialisation
        SortManager sortManager = new SortManager(sortMethod);
        int[] sortedArray;

        // sorting of array and timer management------------------------------
        Timer timer = new Timer();
        timer.start();
        sortedArray=sortManager.sortArray(arrayToSort);
        double millisecondTime = timer.getCurrentMilliseconds();
        // output of sorted array--------------------------------------------
        System.out.println(sortMethod.getSortMethod() + " took " + millisecondTime + " milliseconds to sort the array");
        Thread.sleep(1000);
        List <Integer> sortedList= Arrays.asList(ArrayUtilities.intArrayToIntegerList(sortedArray));
        System.out.println("The sorted array layout:");

        ArrayUtilities.readArray(sortedList);




    }

}

