package com.company.view;

import org.apache.log4j.Logger;

public class Notification {
    public static Logger logger = Logger.getLogger(Notification.class);
    public static void wrongInput(){
        logger.warn("Invalid input. Try again.");
    }
    public static void exitStatus(){
        logger.info("Exited");
    }
    public void logEr(){
        logger.warn("Wrong data input. Try again.");
    }
    public static void emptyList(){
        logger.info("List is empty. Please add new task.");
    }
}