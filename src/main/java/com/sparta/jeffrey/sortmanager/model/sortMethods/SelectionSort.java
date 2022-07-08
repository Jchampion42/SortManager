package com.sparta.jeffrey.sortmanager.model.sortMethods;

public class SelectionSort implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        {
            int n = arrayToSort.length;
            for (int i = 0; i < n-1; i++)
            {
                int minLocation = i;
                for (int j = i+1; j < n; j++)
                    if (arrayToSort[j] < arrayToSort[minLocation])
                        minLocation = j;

                // swap minimum element with compared element
                int temp = arrayToSort[minLocation];
                arrayToSort[minLocation] = arrayToSort[i];
                arrayToSort[i] = temp;
            }
            return arrayToSort;
        }
    }
}
