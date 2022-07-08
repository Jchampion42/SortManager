package com.sparta.jeffrey.sortmanager;

import com.sparta.jeffrey.sortmanager.core.SortProgram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static Logger logger = LogManager.getLogger("My Logger");
    public static void main(String[] args){
        SortProgram sortProgram=new SortProgram();
        sortProgram.run();
    }
}

