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
Add the option to use a merge sort algorithm instead.
Include JUnit tests for this and all subsequent phases (and all subsequent projects for the rest of time).

Phase 2
Update your project to use MVC and start to incorporate some of the design principles discussed earlier in the course (OOP, SOLID, design patterns).
Create classes which implements MVC, including SortManager (controller) and DisplayManager (view) classes.
The code should include a basic factory pattern to determine which sorter to use.
Make sure packages are created properly and the structure follows the MVC pattern.
The code should separate the business logic (sorters) from the display to show MVC in action.
display - Classes that deal with printing to the console window.
exceptions - Any custom exceptions which will be thrown.
sorters - The sort algorithms with Sorter interface for the Factory pattern.
(Within sorters) binaryTree - Logic for the binary tree including contract interface (see Phase 4).
start - Factory pattern for sorters, loader for run logic and Java main method.
Create an interface which both sort classes can implement and make sure your application uses this interface where possible.

Phase 3
Add logging code into the Sort Manager project.
Set up log4j in the project and add a .properties file.
Create logs at different levels and fully test the resulting output.
Have output going to a log file created in the resources directory.
Ensure there are meaningful log messages added to the project and that they reflect the needs of the levels for which they are set.

Phase 4
Integrate a new class to implement a tree sort, using a binary search tree, so that the tree sort can be called in the same way as the other sort algorithms.
The new class should implement the current Sorter interface.
Add code that calls the BST and passes in the array that will be used to construct the tree and then return a sorted array.
Use the Facade design pattern for this step.
Implement a nested class to represent a node in the tree.

Phase 5
Add timing information to the project and allow the user to select multiple algorithms to compare their performance.
Submission
Code should be hosted on your own Github page with a suitable README.md file.
If you want to keep your repo private, add your trainer as a collaborator and email them to say what your GitHub username is.
A link to your completed project should be emailed to your trainers by 23:59 on 2022-07-10.




ALL VARIABLE IN MAIN
SortMethodEnum sortMethod   - an enum pointer, initialised by the user, then used as a reference to the sort algorithm
int arrayLength             - a number received by the user to indicate a desired length
List <Integer> listToSort   - a list generated from int array length
SortManager sortManager     - an instance of the sort manager class
int[] arrayToSort           - like list to sort, but an array
int[] sortedArray           - a location to store the sorted array
millisecondTime             - a place to store timer information as soon as possible
List <Integer> sortedList   -like sortedarray, but a list.

        */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Initialisation of variables---------------------------------------
        SortMethodEnum sortMethod; // establish enum list

        System.out.println("Welcome to the array sorting program!\n");
        Thread.sleep(750); // delays to improve user experience
        System.out.println("In this program we will be sorting an array of integers.\n");
        Thread.sleep(750); // delays to improve user experience
        System.out.println("First, select a method to use by typing its number:");
        for (SortMethodEnum s : SortMethodEnum.values()){ // prints a list to the user of all enums in the list representing the different sort methods
            System.out.println(s.getSortKey()+ ". " +s.getSortMethod());
        }

        //obtain desired sort algorithm--------------------------------------
        sortMethod=UserChoiceModule.getUserEnum(); // selection module to return an enum for storage related to the list available

        System.out.println("\nInitializing " + sortMethod.getSortMethod());
        Thread.sleep(750);

        //obtain desired length of array to sort-----------------------------
        int arrayLength;
        arrayLength= UserChoiceModule.getUserArrayLength(); // selection module to obtain a length of value 1 or greater

        List <Integer> listToSort= ArrayUtilities.makeRandomIntArray(arrayLength); //creates an array with random values using the length provided
        System.out.println("The original array layout:");

        // readout of initial array -----------------------------------------
        ArrayUtilities.readArray(listToSort); // array utilities function to read out an array
        Thread.sleep(1500);
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

