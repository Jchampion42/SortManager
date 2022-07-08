package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.core.ArrayUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilitiesTest {
    @BeforeEach
    public void setup(){
    }

    @Test
    @DisplayName("Array length test")
    public void getRandomArrayLength(){
        int arraySize = 5;
        int[] testArray = ArrayUtilities.makeRandomIntArray(arraySize);
        assertEquals(testArray.length, arraySize);
    }


}