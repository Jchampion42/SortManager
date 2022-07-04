package com.sparta.jeffrey;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayUtilities {
    ArrayUtilities(){
    }

    public static List<Integer> makeRandomIntArray(int arrayLength){
        // method to create an array with random vales of a length equal to the input

        Random random= new Random();
        Integer[] intArray = new Integer[arrayLength];
        for (int i =0; i<intArray.length; i++){
            intArray[i] = i; //redundancy, program complained when values weren't initialised
            intArray[i] = random.nextInt(100);
        }
        return Arrays.asList(intArray);
    }
    public static Integer[] intArrayToIntegerList(int [] inputArray){
        // method to turn an integer array to a list, as the method says

        Integer[] integerArray = new Integer[inputArray.length];
        for (int i =0; i<integerArray.length; i++){
            integerArray[i] = inputArray[i];
        }
        return integerArray;
    }

    public static <Thing> void readArray(List<Thing> array){
        // generic array for if anything will want to read strings/doubles in the future

        for (Thing t : array){
            System.out.print(" " + t);
        }
        System.out.println();
    }
}
