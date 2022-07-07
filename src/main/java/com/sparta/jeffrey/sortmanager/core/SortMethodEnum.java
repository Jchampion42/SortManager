package com.sparta.jeffrey.sortmanager.core;

public enum SortMethodEnum {
    // Update new methods here
    BUBBLESORT ("bubble sort" , 1),
    MERGESORT ("merge sort",2),
    BINARYTREESORT ("binary tree", 3);

    private final String sortMethod;
    private final int enumKey;

    SortMethodEnum(String sortName , int keyValue){
        this.enumKey=keyValue;
        this.sortMethod=sortName;
    }
    //----------GETTERS----------------

    public String getSortMethod() {
        return sortMethod;
    }

    public int getSortKey() {
        return enumKey;
    }

}
