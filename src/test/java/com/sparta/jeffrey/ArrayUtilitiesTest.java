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


}