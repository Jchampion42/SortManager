package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.core.SortProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
O Write a program which will take an array of ints and sort it using a bubble sort algorithm.
O Add the option to use a merge sort algorithm instead.
O Include JUnit tests for this and all subsequent phases (and all subsequent projects for the rest of time).

Phase 2
? Update your project to use MVC and start to incorporate some of the design principles discussed earlier in the course (OOP, SOLID, design patterns).
? Create classes which implements MVC, including SortManager (controller) and DisplayManager (view) classes.
O The code should include a basic factory pattern to determine which sorter to use.
? Make sure packages are created properly and the structure follows the MVC pattern.
? The code should separate the business logic (sorters) from the display to show MVC in action.
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
    public static Logger logger = LogManager.getLogger("My Logger");
    public static void main(String[] args){
        SortProgram sortProgram=new SortProgram();
        sortProgram.run();
    }

}
