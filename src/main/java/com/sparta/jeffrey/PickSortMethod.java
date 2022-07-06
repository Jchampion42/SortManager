package com.sparta.jeffrey;
// THIS FILE NEEDS UPDATING WITH NEW IMPLEMENTATIONS
public class PickSortMethod {
    public static Sorter keyToMethod (SortMethodEnum sortKey){
        Sorter targetMethod;
        // UPDATE SWITCH WITH NEW METHODS WHEN ADDED---------------------------------XXXXXXXXX
        targetMethod = switch (sortKey){
            case BUBBLESORT : yield  new BubbleSort();
            case MERGESORT  : yield  new MergeSort();
        };
        return targetMethod;
    }
}
