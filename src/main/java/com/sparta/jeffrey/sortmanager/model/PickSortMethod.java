package com.sparta.jeffrey.sortmanager.model;

import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;
import com.sparta.jeffrey.sortmanager.model.sortMethods.BinaryTreeSort;
import com.sparta.jeffrey.sortmanager.model.sortMethods.BubbleSort;
import com.sparta.jeffrey.sortmanager.model.sortMethods.MergeSort;
import com.sparta.jeffrey.sortmanager.model.sortMethods.Sorter;

// THIS FILE NEEDS UPDATING WITH NEW IMPLEMENTATIONS
public class PickSortMethod {
    public static Sorter keyToMethod (SortMethodEnum sortKey){
        Sorter targetMethod;
        // UPDATE SWITCH WITH NEW METHODS WHEN ADDED---------------------------------XXXXXXXXX
        targetMethod = switch (sortKey){
            case BUBBLESORT     : yield  new BubbleSort();
            case MERGESORT      : yield  new MergeSort();
            case BINARYTREESORT : yield  new BinaryTreeSort();
        };
        return targetMethod;
    }
}
