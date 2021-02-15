package com.company.view;

import org.apache.log4j.Logger;

public class Notification {
    public static Logger logger = Logger.getLogger(Notification.class);

    /**
     * Wrong input method logs wrong user's input.
     */
    public static void wrongInput(){
        logger.warn("Invalid input. Try again.");
    }

    /**
     * Exit status method logs exiting from an application.
     */
    public static void exitStatus(){
        logger.info("Exited");
    }

    /**
     * This method logs wrong data input.
     */
    public void logEr(){
        logger.warn("Wrong data input. Try again.");
    }

    /**
     * Empty list method logs empty list of tasks.
     */
    public static void emptyList(){
        logger.info("List is empty. Please add new task.");
    }
}