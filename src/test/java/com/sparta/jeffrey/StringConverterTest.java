package com.sparta.jeffrey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringConverterTest {
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