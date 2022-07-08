package com.sparta.jeffrey.sortmanager.view;

import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;
import com.sparta.jeffrey.sortmanager.core.ArrayUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
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
        System.out.println(sortMethod.getSortMethod() + " took " + Math.floor(time*10000)/10000 + " milliseconds on average to sort the array\n");
        Thread.sleep(2000);
    }
    public boolean repeatCheck(){
        return UserChoiceModule.repeatSorter();
    }
    public void historyCheck(List<Double> timeList,List<SortMethodEnum> sortMethodList,  List<Integer> lengthList){
        System.out.println("\n \n__________________LEADER BOARDS___________________");
        System.out.println("\n your score will be rated by length^0.8 / time taken!!\n");
        List <Double> scoreList = new ArrayList<>();

        int longestPosition=-1;
        int fastestPosition=-1;
        int bestScorePosition=-1;
        Double bestScoreValue=0.0;
        Integer longestValue= lengthList.get(0);
        Double fastestValue= timeList.get(0);
        for (int i=0 ; i<sortMethodList.size(); i++){

            if (timeList.get(i)<=fastestValue){
                fastestPosition=i;
                fastestValue=timeList.get(i);
            }
            if(lengthList.get(i)>=longestValue){
                longestValue=lengthList.get(i);
                longestPosition=i;
            }
            scoreList.add(Math.pow(lengthList.get(i),0.8)/timeList.get(i)); // modify score values here
            if (scoreList.get(i)>bestScoreValue){
                bestScoreValue=scoreList.get(i);
                bestScorePosition=i;
            }

        }
        for (int i=0; i<sortMethodList.size();i++){
            System.out.print(i+ ". Method: " + sortMethodList.get(i).getSortMethod() + "\t Length: " + lengthList.get(i));
            if (i == longestPosition) {
                System.out.print(" **CURRENT BEST** ");
            }
            System.out.print("\tTime: " + Math.floor(timeList.get(i) * 10000) / 10000 + " milliseconds");
            if (i == fastestPosition){
                System.out.print(" **CURRENT BEST** ");
            }
            System.out.print("\t Score: "+ Math.floor(scoreList.get(i) * 100) / 100);
            if (i == bestScorePosition){
                System.out.print(" **CURRENT BEST** ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static class UserChoiceModule {
        public static SortMethodEnum getUserEnum(){
            Scanner scanner = new Scanner(System.in);
            SortMethodEnum sortMethod=SortMethodEnum.BUBBLESORT;
            boolean userChoosing = true;
            String userInput;
            int userInputAsInt;

            while (userChoosing) {
                userInput = scanner.next();
                userInputAsInt= StringConverter.stringToInt(userInput); // personalised string-to int converter, reads for any ints and always returns positive
                for (SortMethodEnum s : SortMethodEnum.values()){ // checks through the list of enums to see if the input key matches user input key then returns relevant enum
                    if (s.getSortKey()==userInputAsInt){
                        userChoosing=false;
                        sortMethod=s;
                    }
                }
                if (userChoosing){
                    System.out.println("please check you entered a valid number\n \nPlease enter a number corresponding to a sort method");
                }
            }
            return sortMethod;
        }

        public static int getUserArrayLength(){
            boolean userChoosing=true;
            Scanner scanner = new Scanner(System.in);
            int userValue=1;
            while (userChoosing) {
                System.out.println("Please input a length for the array to sort");
                userValue= StringConverter.stringToInt(scanner.next()); // uses converter to only return a positive int, and loop refuses a null array.
                if (userValue != 0){
                    userChoosing=false;
                }
            }
            return  userValue;
        }

        public static boolean repeatSorter(){
            Scanner scanner= new Scanner(System.in);
            boolean returnValue=false;
            String userInput;
                ValueGot:while (true) {
                    System.out.println("Would you like to select another sorting algorithm? (Y or N)");
                    userInput = scanner.next().toLowerCase(Locale.ROOT);
                    switch (userInput) {
                        case "y":   returnValue=true;      break ValueGot;
                        case "n":   break ValueGot;
                    }
                }
            return returnValue;
        }
    }

    public static class StringConverter {
        public static int stringToInt(String inputString){
            StringBuilder stringBuilder= new StringBuilder(inputString.length());
            stringBuilder.append(0);
            char [] inputAsCharArray = inputString.toCharArray();
            // char value 48-57 are numerics
            for (char c : inputAsCharArray){
                if (c>= 48 && c<=57){
                    stringBuilder.append(c);
                }
            }
            // System.out.println(stringBuilder);
            return Integer.parseInt(stringBuilder.toString());
        }
    }
}
