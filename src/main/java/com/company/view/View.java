package com.company.view;

import com.company.Observer;
import com.company.controller.MainController;
import java.util.Date;

public class View implements Observer {

    public MainController mainController;

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void update() {
        displayTasks();
    }

    /**
     * Register current class as "subscriber according to Observer pattern".
     */
    public void register() {

        mainController.getModel().registerUsers(this);
    }

    /**
     * Display tasks.
     */
    public void displayTasks(){
        for(int i = 0; i < mainController.getModel().getTaskList().size(); i++) {
            System.out.println((i+1) + "." + mainController.getModel().getTaskList().getTask(i).toString());
        }
        System.out.println("\nReturning to the menu.");
        PrintMenu.printMainMenu();
    }

    /**
     * Display tasks for removing.
     */
    public void displayTasksForRemoving(){
        for(int i = 0; i < mainController.getModel().getTaskList().size(); i++) {
            System.out.println((i+1) + "." + mainController.getModel().getTaskList().getTask(i).toString());
        }
    }

    /**
     * Display scheduled tasks.
     */
    public void displayScheduledTasks(){
        int counter = 1;
        for(int i = 0; i < mainController.getModel().getTaskList().size(); i++) {
            if(mainController.getModel().getTaskList().getTask(i).isScheduled(new Date())){
                System.out.println((counter++) + "." + mainController.getModel().getTaskList().getTask(i).toString());
            }
        }
        PrintMenu.printMainMenu();
    }

    /**
     * Method prints menu of removing task.
     */
    public void remove(){
        String remover = "Write the index of the task to remove it from your list.";
        System.out.println(remover);
        this.displayTasksForRemoving();
        mainController.remove();
    }

    /**
     * Method prints menu of changing repeated task.
     */
    public void repeatTasks() {
        System.out.println("Enter:");
        System.out.println("Title");
        System.out.println("Time of a new task hh:mm");
        System.out.println("Date of a new task dd/MM/yyyy");
        System.out.println("Task end time hh:mm");
        System.out.println("Task end date dd/MM/yyyy");
        System.out.println("Set an interval in seconds");
        mainController.menuOfAddingRepeatedTasks();
    }

    /**
     * Method prints menu of changing not repeated task.
     */
    public void norepeat(){
        System.out.println("Enter:");
        System.out.println("Title");
        System.out.println("Time hh:mm ");
        System.out.println("Date dd/MM/yyyy");
        mainController.menuOfNoRepeatTasks();
    }

    /**
     * Method prints choosing task and calls switching an activity.
     */
    public void active(){
        displayTasksForRemoving();
        System.out.println("Choose the task: ");
        mainController.active();
    }

    /**
     * Method prints information of getting back stage.
     */
    public void ret(){
        System.out.println("Returning back");
        PrintMenu.printMainMenu();
    }

    /**
     * Method prints menu of changing title.
     */
    public void title(){
        displayTasksForRemoving();
        System.out.println("Write a new title of your task");
        System.out.println("Choose the index of the task");
        mainController.title();
    }

    /**
     * Method prints menu of changing time.
     */
    public void time(){
        displayTasksForRemoving();
        System.out.println("Set the time hh:mm");
        System.out.println("Set the date dd/MM/yyyy");
        System.out.println("Choose the index of your task:");
        mainController.time();
    }

    /**
     * Method prints menu of changing repeated task.
     */
    public void exec(){
        displayTasksForRemoving();
        System.out.println("Firstly choose the taks beforehand and enter:");
        System.out.println("Start time hh:mm");
        System.out.println("Start date dd/MM/yyyy");
        System.out.println("End time hh:mm");
        System.out.println("End date dd/MM/yyyy");
        System.out.println("Interval");
        System.out.println("Index of the task");
        mainController.exec();
    }
}
