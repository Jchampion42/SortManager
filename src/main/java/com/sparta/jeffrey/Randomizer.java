package com.sparta.jeffrey;

import java.util.Random;
import java.util.Scanner;

public class Randomizer {
    Randomizer(){
    }
    public int getUserArrayLength(){
        boolean userChoosing=true;
        Scanner scanner = new Scanner(System.in);
        int userValue=1;
        while (userChoosing) {
            System.out.println("Please input a length for your array");
            userValue=stringToInt(scanner.next());
            if (userValue != 0){
                userChoosing=false;
            }
        }
        return  userValue;
    }

    public int [] makeIntArray(int arrayLength){
        Random random= new Random();
        int[] intArray = new int[arrayLength];
        for (int i : intArray){
            i = random.nextInt();
        }
        return intArray;
    }
    public int stringToInt(String inputString){
        StringBuilder stringBuilder= new StringBuilder(inputString.length());
        stringBuilder.append(0);
        char [] inputAsCharArray = inputString.toCharArray();
        // char value 48-57 are numerics
        for (char c : inputAsCharArray){
            if (c>= 48 && c<=57){
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
        return Integer.parseInt(stringBuilder.toString());
    }

    public <Thing> void readArray(Thing[] array){
        System.out.println("The original array layout:");
        for (Thing t : array){
            System.out.println("" + t);
        }
    }
}
