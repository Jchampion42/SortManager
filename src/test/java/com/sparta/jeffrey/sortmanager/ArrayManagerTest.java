package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.core.FetchArrayException;
import com.sparta.jeffrey.sortmanager.model.ArrayManager;
import com.sparta.jeffrey.sortmanager.core.ArrayUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayManagerTest {
    ArrayManager arrayManager;
    @BeforeEach
    void setup(){
        arrayManager= new ArrayManager();
    }
    @Test
    void getNullArrays(){

        Exception exception= assertThrows(FetchArrayException.class, ()->{arrayManager.getSortedIntArray();});
        assertEquals("A sorted array has not been defined/generated",exception.getMessage());

        exception= assertThrows(FetchArrayException.class, ()->{arrayManager.getUnsortedIntArray();});
        assertEquals("An unsorted array has not been defined/generated",exception.getMessage());
    }
    @Test
    @DisplayName("Array length test")
    public void getRandomArrayLength(){
        int arraySize = 5;
        int[] testArray = ArrayUtilities.makeRandomIntArray(arraySize);
        assertEquals(testArray.length, arraySize);
    }
}