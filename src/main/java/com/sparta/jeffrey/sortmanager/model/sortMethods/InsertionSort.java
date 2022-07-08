package com.sparta.jeffrey.sortmanager.model.sortMethods;

public class InsertionSort implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        for(int i=0;i<arrayToSort.length;++i){
            int j = i;
            while(j > 0 && arrayToSort[j-1]>arrayToSort[j]){

                int temp = arrayToSort[j];
                arrayToSort[j] = arrayToSort[j-1];
                arrayToSort[j-1] = temp;
                j = j-1;

            }
        }
        return arrayToSort;
    }
}
