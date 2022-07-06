package com.sparta.jeffrey;
import static com.sparta.jeffrey.Main.logger;

public class SortProgram {
    public void run(){
        SortManager sortManager= new SortManager();
        try {
            sortManager.startProgram();
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
