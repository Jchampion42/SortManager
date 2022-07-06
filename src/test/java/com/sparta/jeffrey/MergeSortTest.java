package com.sparta.jeffrey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    MergeSort mergeSort=new MergeSort();
    @Test
    public void defaultMergeTest(){
        int [] test1ExpectedResult= {1,2,3,4,5};
        int [] test1Input= {4,3,5,2,1};
        assertArrayEquals(test1ExpectedResult,mergeSort.sortArray(test1Input));
    }
    @Test
    public void repeatedArrayTest(){
        int [] test1ExpectedResult= {1,1,1,2,2,2,3,3,3};
        int [] test1Input= {3,2,1,3,2,1,3,2,1};
        assertArrayEquals(test1ExpectedResult,mergeSort.sortArray(test1Input));
    }
}