package com.sparta.jeffrey;

public class SortManager {
    private final Sorter sorter;

    public SortManager (SortMethodEnum sortKey){
        sorter= PickSortMethod.keyToMethod(sortKey);
    }
    public int [] sortArray (int[] array){
        array=sorter.sortArray(array);
        return array;
    }
}
