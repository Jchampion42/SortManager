package com.sparta.jeffrey.sortmanager.model;

import com.sparta.jeffrey.sortmanager.core.FetchArrayException;
import com.sparta.jeffrey.sortmanager.core.SortMethodEnum;
import com.sparta.jeffrey.sortmanager.model.sortMethods.Sorter;
import com.sparta.jeffrey.sortmanager.model.utilities.Timer;

public class ArrayManager {


    private int [] unsortedIntArray;
    private int [] sortedIntArray;

    private SortMethodEnum sortMethod;

    private Sorter sorter;

    private double timeTaken;
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
        timer.start();
        sortedIntArray=sorter.sortArray(unsortedIntArray);
        timeTaken=timer.getCurrentMilliseconds();
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
}
