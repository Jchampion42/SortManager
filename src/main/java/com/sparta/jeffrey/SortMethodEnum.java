package com.sparta.jeffrey;

public enum SortMethodEnum {
    // Update new methods here
    BUBBLESORT ("bubble sort" , 1);

    private String sortMethod;
    private int enumKey;

    SortMethodEnum(String sortName , int keyValue){
        this.enumKey=keyValue;
        this.sortMethod=sortName;
    }
    //----------GETTERS SETTERS----------------
    public void setSortMethod(String sortMethod) {
        this.sortMethod = sortMethod;
    }
    public String getSortMethod() {
        return sortMethod;
    }
    public void setSortKey(int sortKey) {
        this.enumKey = sortKey;
    }
    public int getSortKey() {
        return enumKey;
    }

}
