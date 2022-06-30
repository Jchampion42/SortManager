package com.sparta.jeffrey;

public enum SortMethods {
    // Update new methods here
    BUBBLESORT ("bubble sort" , 1);




    private String sortMethod;



    private int sortKey;
    SortMethods(String sortName , int keyValue){
        this.sortKey=keyValue;
        this.sortMethod=sortName;
    }
    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
    public String getSortMethod() {
        return sortMethod;
    }
    public void setSortKey(int sortKey) {
        this.sortKey = sortKey;
    }
    public int getSortKey() {
        return sortKey;
    }

}
