package com.sparta.jeffrey;

import java.util.Random;
import java.util.Scanner;

public class Randomizer {
    Randomizer(){
    }
    public int getUserLength(){
        Scanner scanner = new Scanner(System.in);
        return  0;
    }

    public int [] makeIntArray(int arrayLength){


        Random random = new Random();
        return new int[0];
    }
    public int StringToInt(String inputString){
        StringBuilder stringBuilder= new StringBuilder(inputString.length());
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

}
