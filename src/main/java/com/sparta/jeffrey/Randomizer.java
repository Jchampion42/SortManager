package com.sparta.jeffrey;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Randomizer {
    Randomizer(){
    }
    public static int getUserArrayLength(){
        boolean userChoosing=true;
        Scanner scanner = new Scanner(System.in);
        int userValue=1;
        while (userChoosing) {
            System.out.println("Please input a length for the array to sort");
            userValue=stringToInt(scanner.next());
            if (userValue != 0){
                userChoosing=false;
            }
        }
        return  userValue;
    }

    public static List<Integer> makeIntArray(int arrayLength){
        Random random= new Random();
        Integer[] intArray = new Integer[arrayLength];
        for (int i =0; i<intArray.length; i++){
            intArray[i] = i;
            intArray[i] = (Integer) random.nextInt(100);
        }
        List<Integer> intList = Arrays.asList(intArray);
        return intList;
    }
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

    public static <Thing> void readArray(List<Thing> array){
        System.out.println("The original array layout:");
        for (Thing t : array){
            System.out.print(" " + t);
        }
        System.out.println("");
    }
}
