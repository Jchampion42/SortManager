package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.model.sortMethods.BubbleSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    BubbleSort bubbleSort=new BubbleSort();
    @Test
    public void bubbleTest(){
        int [] test1ExpectedResult= {1,2,3,4,5};
        int [] test1Input= {4,3,5,2,1};
        assertArrayEquals(test1ExpectedResult,bubbleSort.sortArray(test1Input));
    }
}