package com.sparta.jeffrey.sortmanager.model;

import com.sparta.jeffrey.sortmanager.core.ArrayUtilities;
import com.sparta.jeffrey.sortmanager.core.FetchArrayException;
import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;
import com.sparta.jeffrey.sortmanager.model.sortMethods.*;
import com.sparta.jeffrey.sortmanager.model.utilities.Timer;

import java.util.ArrayList;
import java.util.List;
import static com.sparta.jeffrey.sortmanager.Main.logger;

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
        logger.info("array created in array management");
    }
    public void createSortMethod(){
        sorter= PickSortMethod.keyToMethod(sortMethod);
        logger.info("method selected in array management");
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
        logger.info("commencing sort operation in array management");
        logger.debug("array size sent to sort: " + unsortedIntArray.length + " sort iterations to perform: " + sortCount);
        for (int i=0; i<sortCount; i++) {
            timer.start();
            sortedIntArray = sorter.sortArray(unsortedIntArray);
            timeTaken += timer.getCurrentMilliseconds();
        }
        logger.info("sort operation completed");
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
            // UPDATE SWITCH WITH NEW METHODS WHEN ADDED---------------------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            targetMethod = switch (sortKey){
                case BUBBLESORT     : yield  new BubbleSort();
                case MERGESORT      : yield  new MergeSort();
                case BINARYTREESORT : yield  new BinaryTreeSort();
                case INSERTIONSORT  : yield  new InsertionSort();
                case SELECTIONSORT  : yield  new SelectionSort();
            };
            return targetMethod;
        }
    }
}
