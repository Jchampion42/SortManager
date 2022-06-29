package com.sparta.jeffrey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {
    Randomizer randomizer;
    @BeforeEach
    public void setup(){
        randomizer = new Randomizer();
    }

    @Test
    @DisplayName("Array length test")
    public void GetRandomArrayLength(){
        assertEquals(5, randomizer.makeIntArray(5));
    }
    @Test
    @DisplayName("Default string to int test")
    public void StringToIntDefault(){
        assertEquals(123, randomizer.StringToInt("123"));
    }
    @Test
    @DisplayName("string with words, numbers and symbols to int")
    public void StringToIntWordAndNumber(){
        //program should ignore non-numerical inputs
        assertEquals(456,randomizer.StringToInt("4ab5c6.!?"));
    }
    @Test
    @DisplayName("negative value to int test")
    public void NegativeInput(){
        // program should make absolute value
        assertEquals(5,randomizer.StringToInt("-5"));
    }

}