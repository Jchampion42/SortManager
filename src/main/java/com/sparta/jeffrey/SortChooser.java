package com.sparta.jeffrey;
// THIS FILE NEEDS UPDATING WITH NEW IMPLEMENTATIONS
public class SortChooser {
    public static Sorter keyToMethod (SortMethodEnum sortKey){
        Sorter targetMethod = null;
        switch (sortKey){
            case BUBBLESORT : targetMethod= new BubbleSort(); break;
            default: break;
        }
        return targetMethod;
    }
}
