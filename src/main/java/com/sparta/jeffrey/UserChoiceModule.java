package com.sparta.jeffrey;

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
            userInputAsInt= StringConverter.stringToInt(userInput);
            for (SortMethodEnum s : SortMethodEnum.values()){
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
            userValue= StringConverter.stringToInt(scanner.next());
            if (userValue != 0){
                userChoosing=false;
            }
        }
        return  userValue;
    }
}
