package com.sparta.jeffrey;

public class ArrayManager {


    private int [] unsortedIntArray;
    private int [] sortedIntArray;

    private SortMethodEnum sortMethod;

    private  Sorter sorter;
    public void createRandomArray(int arrayLength){
        unsortedIntArray = ArrayUtilities.makeRandomIntArray(arrayLength);
        sortedIntArray=null;
    }
    public void createSortMethod(){
        sorter= PickSortMethod.keyToMethod(sortMethod);
    }
    public void sortArray () throws FetchArrayException {
        if (unsortedIntArray==null){
            throw new FetchArrayException("A sorted array has not been defined/generated");
        }
        sortedIntArray=sorter.sortArray(unsortedIntArray);
    }





    //-------GETTERS AND SETTERS-------
    public int[] getSortedIntArray() throws FetchArrayException {
        if (sortedIntArray==null){
            throw new FetchArrayException("A sorted array has not been defined/generated");
        }
        return sortedIntArray;
    }

    public void setSortedIntArray(int[] sortedIntArray) {
        this.sortedIntArray = sortedIntArray;
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
