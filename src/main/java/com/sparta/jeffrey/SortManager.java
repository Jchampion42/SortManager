package com.sparta.jeffrey;

public class SortManager {
    private Sorter sorter;

    public SortManager (SortMethodEnum sortKey){
        sorter=SortChooser.keyToMethod(sortKey);
    }
    public int [] sortArray (int[] array){
        array=sorter.sortArray(array);
        return array;
    }
}
