package com.sparta.jeffrey.sortmanager.model.sortMethods;

public class MergeSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        if (arrayToSort.length==1)return arrayToSort;
        int[] arrayLeft=new int[arrayToSort.length/2];
        int[] arrayRight= new int[arrayToSort.length-arrayLeft.length];
        int i=0;
        while (i<arrayLeft.length){
            arrayLeft[i]=arrayToSort[i];
            i++;
        }
        int j=0;
        while (j<arrayRight.length){
            arrayRight[j]=arrayToSort[i];
            j++;
            i++;
        }
        int[] sortedLeft = sortArray(arrayLeft);
        int[] sortedRight = sortArray(arrayRight);
        return  mergeTwoSortedArrays(sortedLeft,sortedRight);
    }
    private static int[] mergeTwoSortedArrays(int[] array1 , int[] array2){
        int[] mergeArray = new int [array1.length + array2.length];
        int i=0 , j= 0, k=0;
        while (i< array1.length && j<array2.length){
            if (array1[i] == array2[j]){
                mergeArray[k]=array1[i];
                k++ ;
                i++ ;
                mergeArray[k]=array2[j];
                k++;
                j++;
            }
            else if (array1[i] < array2[j]){
                mergeArray[k]=array1[i];
                k++ ;
                i++ ;
            }
            else if (array1[i] > array2[j]){
                mergeArray[k]=array2[j];
                k++;
                j++;
            }

        }
        while (i<array1.length){
            mergeArray[k++]=array1[i++];
        }
        while (j< array2.length){
            mergeArray[k++]=array2[j++];
        }
        return  mergeArray;
    }
}
