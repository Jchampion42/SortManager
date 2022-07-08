package com.sparta.jeffrey.sortmanager.core;

import java.util.List;
import java.util.Random;

public class ArrayUtilities {
    ArrayUtilities() {
    }

    public static int[] makeRandomIntArray(int arrayLength) {
        // method to create an array with random vales of a length equal to the input

        Random random = new Random();
        int[] intArray = new int[arrayLength];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i; //redundancy, program complained when values weren't initialised
            intArray[i] = random.nextInt(arrayLength * 4);
        }
        return intArray;
    }

    public static <Thing> void readArray(List<Thing> array) {
        // generic array for if anything will want to read strings/doubles in the future

        for (Thing t : array) {
            System.out.print(" " + t);
        }
        System.out.println();
    }
}
