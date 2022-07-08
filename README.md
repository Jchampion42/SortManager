# SortManager
## An application to test the efficiency of different implementations of sort methods in java


##The task specifications
### You will be building a program that will allow a user to sort a randomised array.
#### The general flow of the application is:
 * The user is presented with a number of sort algorithms to choose from.
 * Decision is given via the command line (using Scanner).
 * The program will then ask for the length of an array again via the command line.

#### The program should then output:
 * The unsorted randomly generated array
 * The sort algorithm to be used
 * The sorted array after the algorithm has been executed
 * The time taken

#### You are required to test both the functionality of the program and the performance of the algorithms (speed tests)

### Suggested Project Phases.
#### Phase 1
 * Write a program which will take an array of ints and sort it using a bubble sort algorithm.
 * Add the option to use a merge sort algorithm instead.
 * Include JUnit tests for this and all subsequent phases (and all subsequent projects for the rest of time).

#### Phase 2
 * Update your project to use MVC and start to incorporate some of the design principles discussed earlier in the course (OOP, SOLID, design patterns).
 * Create classes which implements MVC, including SortManager (controller) and DisplayManager (view) classes.
 * The code should include a basic factory pattern to determine which sorter to use.
 * Make sure packages are created properly and the structure follows the MVC pattern.
 * The code should separate the business logic (sorters) from the display to show MVC in action.
 * Create an interface which both sort classes can implement and make sure your application uses this interface where possible.
 
display - Classes that deal with printing to the console window.
exceptions - Any custom exceptions which will be thrown.
sorters - The sort algorithms with Sorter interface for the Factory pattern.
(Within sorters) binaryTree - Logic for the binary tree including contract interface (see Phase 4).
start - Factory pattern for sorters, loader for run logic and Java main method.


#### Phase 3
 * Add logging code into the Sort Manager project.
 * Set up log4j in the project and add a .properties file.
 * Create logs at different levels and fully test the resulting output.
 * Have output going to a log file created in the resources directory.
 * Ensure there are meaningful log messages added to the project and that they reflect the needs of the levels for which they are set.

#### Phase 4
 * Integrate a new class to implement a tree sort, using a binary search tree, so that the tree sort can be called in the same way as the other sort algorithms.
 * The new class should implement the current Sorter interface.
 * Add code that calls the BST and passes in the array that will be used to construct the tree and then return a sorted array.
 - Use the Facade design pattern for this step.
* Implement a nested class to represent a node in the tree.

#### Phase 5
* Add timing information to the project and allow the user to select multiple algorithms to compare their performance.

### Assumtions
#### phase 1
**Assumtion:** the choice of using a merge algorithm can be called from the console window.
*Implementation:* the scanner class was used to allow for console interfacing

#### phase 2
**Assumption: ** the requirement of an MVC pertains to three distinct classes for data storage and manipulation (model) , user interaction (view) and linking the two previous (controller)
*Implementation* three primary classes, ArrayManager (model), DisplayManager(view) and SortManager(controller)
**Assumption: ** including a factory pattern to determine which sorter to use pertains to the usage of a factory within the process of getting a sort method
*Implementation* Enumbers were created to act as keys and links of information which are repeatedly referenced throughout the project to initialise any sort method

#### phase 5
**Assumption** allowing the user to select multiple algorithms means that throughout the programs exectution they may select any algorithm and length to sort and test it on a new randomly generated array
*implementation* Storage of information that regards to the sort desired, and display of a leaderboard containing the history of any sort algorithms used



