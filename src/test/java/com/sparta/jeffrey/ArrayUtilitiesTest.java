package com.sparta.jeffrey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilitiesTest {
    ArrayUtilities arrayUtilities;
    @BeforeEach
    public void setup(){
        arrayUtilities = new ArrayUtilities();
    }

    @Test
    @DisplayName("Array length test")
    public void GetRandomArrayLength(){
        int arraySize = 5;
        List<Integer> testArray = arrayUtilities.makeRandomIntArray(arraySize);
        assertEquals(testArray.size(), arraySize);
    }
    @Test
    @DisplayName("Default string to int test")
    public void StringToIntDefault(){
        assertEquals(123, StringConverter.stringToInt("123"));
    }
    @Test
    @DisplayName("string with words, numbers and symbols to int")
    public void StringToIntWordAndNumber(){
        //program should ignore non-numerical inputs
        assertEquals(456, StringConverter.stringToInt("4ab5c6.!?"));
    }
    @Test
    @DisplayName("negative value to int test")
    public void NegativeInput(){
        // program should make absolute value
        assertEquals(5, StringConverter.stringToInt("-5"));
    }

}