package com.sparta.jeffrey.sortmanager.model.sortMethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
    InsertionSort insertionSort= new InsertionSort();
    @Test
    public void insertionTest(){
        int [] test1ExpectedResult= {1,2,3,4,5};
        int [] test1Input= {4,3,5,2,1};
        assertArrayEquals(test1ExpectedResult,insertionSort.sortArray(test1Input));
    }
    @Test public void negativeTest(){
        int [] test1ExpectedResult= {-5,-4,-2,1,2,3,4,5};
        int [] test1Input= {4,3,5,2,1,-2,-5,-4};
        assertArrayEquals(test1ExpectedResult,insertionSort.sortArray(test1Input));
    }
    @Test public void repeatedArrayTest(){
        int [] test1ExpectedResult= {1,1,1,2,2,2,3,3,3};
        int [] test1Input= {3,2,1,3,2,1,3,2,1};
        assertArrayEquals(test1ExpectedResult,insertionSort.sortArray(test1Input));
    }
    @Test public void nullArray(){
        int [] nullArray=null;
        assertThrows(NullPointerException.class, ()->{insertionSort.sortArray(nullArray);});

    }
    @Test public void nullContentTest(){
        int[] nullArray = new int[0];
        assertArrayEquals(nullArray, insertionSort.sortArray(nullArray));
    }
}