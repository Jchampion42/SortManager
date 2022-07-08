package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.view.DisplayManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringConverterTest {
    @Test
    @DisplayName("Default string to int test")
    public void StringToIntDefault(){
        assertEquals(123, DisplayManager.StringConverter.stringToInt("123"));
    }
    @Test
    @DisplayName("string with words, numbers and symbols to int")
    public void StringToIntWordAndNumber(){
        //program should ignore non-numerical inputs
        assertEquals(456, DisplayManager.StringConverter.stringToInt("4ab5c6.!?"));
    }
    @Test
    @DisplayName("negative value to int test")
    public void NegativeInput(){
        // program should make absolute value
        assertEquals(5, DisplayManager.StringConverter.stringToInt("-5"));
    }
}