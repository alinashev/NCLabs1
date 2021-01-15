package com.company.view;

import org.apache.log4j.Logger;

public class Notification {
    public static Logger logger = Logger.getLogger(Notification.class);
    public static void wrongInput(){
        System.out.println("Invalid input. Try again.");
    }
    public static void exitStatus(){
        System.out.println("Exited");
    }
    public void logEr(){
        System.out.println("");
        logger.error("Wrong data input. Try again.");
    }

    public static void setLogger(Logger logger) {
        Notification.logger = logger;
    }

}
