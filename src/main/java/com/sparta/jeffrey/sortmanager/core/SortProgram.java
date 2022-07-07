package com.sparta.jeffrey.sortmanager.core;
import com.sparta.jeffrey.sortmanager.controller.SortManager;

import static com.sparta.jeffrey.sortmanager.Main.logger;

public class SortProgram {
    public void run(){
        SortManager sortManager= new SortManager();
        try {

            sortManager.startProgram();
            int [] warmup= new int[1000000];
            warmup=null;
            logger.info("program initialised");
            sortManager.getUserSortMethod();
            logger.info("user sort method step executed");
            sortManager.generateUserArray();
            logger.info("generate array step completed");
            sortManager.sortArray();
            logger.info("sort array step completed");
        }
        catch (InterruptedException e) {
            logger.error("program was interrupted" + e.getMessage());
            throw new RuntimeException(e);
        } catch (FetchArrayException e) {
            logger.warn("attempted usage of a null or uninitialised array" + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e){
            logger.fatal("something went horribly wrong" + e.getMessage());
        }
    }
}
