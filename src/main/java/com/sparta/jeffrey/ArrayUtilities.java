package com.sparta.jeffrey;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayUtilities {
    ArrayUtilities(){
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

    public static List<Integer> makeRandomIntArray(int arrayLength){
        Random random= new Random();
        Integer[] intArray = new Integer[arrayLength];
        for (int i =0; i<intArray.length; i++){
            intArray[i] = i;
            intArray[i] = (Integer) random.nextInt(100);
        }
        List<Integer> intList = Arrays.asList(intArray);
        return intList;
    }
    public static Integer[] intArrayToIntegerList(int [] inputArray){
        Integer[] integerArray = new Integer[inputArray.length];
        for (int i =0; i<integerArray.length; i++){
            integerArray[i] = inputArray[i];
        }
        return integerArray;
    }

    public static <Thing> void readArray(List<Thing> array){
        for (Thing t : array){
            System.out.print(" " + t);
        }
        System.out.println("");
    }
}
