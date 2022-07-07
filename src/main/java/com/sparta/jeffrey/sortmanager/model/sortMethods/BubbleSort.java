package com.sparta.jeffrey.sortmanager.model.sortMethods;

public class BubbleSort implements Sorter {


    @Override
    public int[] sortArray(int[] arrayToSort) {
        int tempNum;
        for (int i=0 ; i< arrayToSort.length -1 ; i++){
            for (int j = 0 ; j<arrayToSort.length -1 ; j++){
                if(arrayToSort[j]>arrayToSort[j+1]){
                    tempNum=arrayToSort[j+1];
                    arrayToSort[j+1]=arrayToSort[j];
                    arrayToSort[j]=tempNum;
                }
            }
        }
        return arrayToSort;
    }
}
