package com.sparta.jeffrey.sortmanager.model;

import com.sparta.jeffrey.sortmanager.core.ArrayUtilities;
import com.sparta.jeffrey.sortmanager.core.FetchArrayException;
import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;
import com.sparta.jeffrey.sortmanager.model.sortMethods.BinaryTreeSort;
import com.sparta.jeffrey.sortmanager.model.sortMethods.BubbleSort;
import com.sparta.jeffrey.sortmanager.model.sortMethods.MergeSort;
import com.sparta.jeffrey.sortmanager.model.sortMethods.Sorter;
import com.sparta.jeffrey.sortmanager.model.utilities.Timer;

import java.util.ArrayList;
import java.util.List;

public class ArrayManager {


    private int [] unsortedIntArray;
    private int [] sortedIntArray;
    private SortMethodEnum sortMethod;
    private Sorter sorter;
    private double timeTaken;
    private List<Integer> arrayList= new ArrayList<>();
    private List<SortMethodEnum> methodList=new ArrayList<>();
    private List<Double> timeList = new ArrayList<>();
    public void createRandomArray(int arrayLength){
        unsortedIntArray = ArrayUtilities.makeRandomIntArray(arrayLength);
        sortedIntArray=null;
    }
    public void createSortMethod(){
        sorter= PickSortMethod.keyToMethod(sortMethod);
    }
    public void sortArray () throws FetchArrayException {

        Timer timer=new Timer();
        if (unsortedIntArray==null){
            throw new FetchArrayException("An unsorted array has not been defined/generated");
        }
        int sortCount;
        if (unsortedIntArray.length<10){
            sortCount=100;
        }
        else if (unsortedIntArray.length<100){
            sortCount=50;
        }
        else if (unsortedIntArray.length<1000){
            sortCount=20;
        }
        else if (unsortedIntArray.length<10000){
            sortCount=5;
        }
        else if (unsortedIntArray.length<100000){
            sortCount=2;
        }
        else sortCount=1;
        timeTaken=0;
        for (int i=0; i<sortCount; i++) {
            timer.start();
            sortedIntArray = sorter.sortArray(unsortedIntArray);
            timeTaken += timer.getCurrentMilliseconds();
        }
        timeTaken=timeTaken/sortCount;
    }





    //-------GETTERS AND SETTERS-------
    public int[] getSortedIntArray() throws FetchArrayException {
        if (sortedIntArray==null){
            throw new FetchArrayException("A sorted array has not been defined/generated");
        }
        return sortedIntArray;

    }
    public double getTimeTaken() {
        return timeTaken;
    }

    public int[] getUnsortedIntArray() throws FetchArrayException {
        if (unsortedIntArray==null){
            throw new FetchArrayException("An unsorted array has not been defined/generated");
        }
        return unsortedIntArray;
    }
    public SortMethodEnum getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(SortMethodEnum sortMethod) {
        this.sortMethod = sortMethod;
    }
    public List<SortMethodEnum> getMethodList() {
        return methodList;
    }

    public List<Double> getTimeList() {
        return timeList;
    }
    public void addToTimeList(){
        timeList.add(timeTaken);
    }
    public void addToMethodList(){
        methodList.add(sortMethod);
    }
    public List<Integer> getArrayList() {
        return arrayList;
    }
    public void addToArrayList(){
        arrayList.add(unsortedIntArray.length);
    }

    // THIS FILE NEEDS UPDATING WITH NEW IMPLEMENTATIONS
    public static class PickSortMethod {
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
}
