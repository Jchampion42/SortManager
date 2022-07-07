package com.sparta.jeffrey.sortmanager.view;

import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;

import java.util.Scanner;

public class UserChoiceModule {
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
}
