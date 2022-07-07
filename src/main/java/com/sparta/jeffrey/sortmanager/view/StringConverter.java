package com.sparta.jeffrey.sortmanager.view;

public class StringConverter {
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
