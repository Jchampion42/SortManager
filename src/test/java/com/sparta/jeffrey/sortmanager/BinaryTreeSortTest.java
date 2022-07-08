package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.model.sortMethods.BinaryTreeSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSortTest {
    BinaryTreeSort treeSort=new BinaryTreeSort();
    @Test public void defaultMergeTest(){
        int [] test1ExpectedResult= {1,2,3,4,5};
        int [] test1Input= {4,3,5,2,1};
        assertArrayEquals(test1ExpectedResult,treeSort.sortArray(test1Input));
    }
    @Test public void repeatedArrayTest(){
        int [] test1ExpectedResult= {1,1,1,2,2,2,3,3,3};
        int [] test1Input= {3,2,1,3,2,1,3,2,1};
        assertArrayEquals(test1ExpectedResult,treeSort.sortArray(test1Input));
    }
    @Test public void nullContentTest(){
        int[] nullArray = new int[0];
        Exception exception=assertThrows(ArrayIndexOutOfBoundsException.class,()->{treeSort.sortArray(nullArray);});
        assertEquals("Index 0 out of bounds for length 0", exception.getMessage());
    }
    @Test public void nullContentTest2(){
        int[] nullArray = new int[10];
        Exception exception=assertThrows(NullPointerException.class,()->{treeSort.sortArray(nullArray);});
    }
    @Test public void nullArray(){
        int [] nullArray=null;
        assertThrows(NullPointerException.class, ()->{treeSort.sortArray(nullArray);});

    }
    @Test public void negativeTest(){
        int [] test1ExpectedResult= {-5,-4,-2,1,2,3,4,5};
        int [] test1Input= {4,3,5,2,1,-2,-5,-4};
        assertArrayEquals(test1ExpectedResult,treeSort.sortArray(test1Input));
    }
}