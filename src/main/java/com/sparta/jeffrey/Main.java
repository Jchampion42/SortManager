package com.sparta.jeffrey;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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




        ArrayUtilities arrayUtilities =new ArrayUtilities();
        Scanner scanner = new Scanner(System.in);
        SortMethodEnum sortMethod= SortMethodEnum.BUBBLESORT;
        boolean userChoosing = true;
        System.out.println("Welcome to the array sorting program!\n");
        Thread.sleep(750);
        System.out.println("In this program we will be sorting an array of integers.\n");
        Thread.sleep(750);
        System.out.println("First, select a method to use by typing its number:");
    for (SortMethodEnum s : SortMethodEnum.values()){
        System.out.println(s.getSortKey()+ ". " +s.getSortMethod());
    }
        System.out.println("");

        String userInput = "";
        int userInputAsInt;
    while (userChoosing) {
        userInput = scanner.next();
        userInputAsInt= StringConverter.stringToInt(userInput);
        for (SortMethodEnum s : SortMethodEnum.values()){
            if (s.getSortKey()==userInputAsInt){
                userChoosing=false;
                sortMethod=s;
            }
        }
        if (userChoosing==true){
            System.out.println("please check you entered a valid number\n \nPlease enter a number corresponding to a sort method");
        }
    }

        System.out.println("\nInitializing " + sortMethod.getSortMethod());
        Thread.sleep(750);

        int arrayLength=1;
        arrayLength= arrayUtilities.getUserArrayLength();

        List <Integer> listToSort= arrayUtilities.makeRandomIntArray(arrayLength);
        System.out.println("The original array layout:");
        arrayUtilities.readArray(listToSort);
        Thread.sleep(1000);
        System.out.println("Sorting using " + sortMethod.getSortMethod() + " in ");
        for (int i=3 ;i>0 ; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        int[] arrayToSort = listToSort.stream().mapToInt(i->i).toArray();
        SortManager sortManager = new SortManager(sortMethod);
        int[] sortedArray = arrayToSort;

        long timerStart=System.nanoTime();
        sortedArray=sortManager.sortArray(arrayToSort);
        long timerEnd =System.nanoTime();
        double milisecondTime = (timerEnd-timerStart)/1e6;
        System.out.println(sortMethod.getSortMethod() + " took " + milisecondTime + " milliseconds to sort the array");
        Thread.sleep(1000);
        List <Integer> sortedList= Arrays.asList(ArrayUtilities.intArrayToIntegerList(sortedArray));
        System.out.println("The sorted array layout:");

        arrayUtilities.readArray(sortedList);




    }

}

