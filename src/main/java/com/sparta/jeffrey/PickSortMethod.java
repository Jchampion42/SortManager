package com.sparta.jeffrey;
// THIS FILE NEEDS UPDATING WITH NEW IMPLEMENTATIONS
public class PickSortMethod {
    public static Sorter keyToMethod (SortMethodEnum sortKey){
        Sorter targetMethod = null;
        // UPDATE SWITCH WITH NEW METHODS WHEN ADDED---------------------------------XXXXXXXXX
        switch (sortKey){
            case BUBBLESORT : targetMethod= new BubbleSort(); break;
            case MERGESORT  : targetMethod= new MergeSort();break;
            default: break;
        }
        return targetMethod;
    }
}
