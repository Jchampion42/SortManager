package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.model.ArrayManager;
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
    public void GetRandomArrayLength(){
        int arraySize = 5;
        int[] testArray = ArrayManager.ArrayUtilities.makeRandomIntArray(arraySize);
        assertEquals(testArray.length, arraySize);
    }


}