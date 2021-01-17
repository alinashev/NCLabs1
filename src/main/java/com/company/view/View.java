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

    public void register() {

        mainController.getModel().registerUsers(this);
    }

    public void displayTasks(){
        for(int i = 0; i < mainController.getModel().getTaskList().size(); i++) {
            System.out.println((i+1) + "." + mainController.getModel().getTaskList().getTask(i).toString());
        }
        System.out.println("\nReturning to the menu.");
        PrintMenu.printMainMenu();
    }

    public void displayTasksForRemoving(){
        for(int i = 0; i < mainController.getModel().getTaskList().size(); i++) {
            System.out.println((i+1) + "." + mainController.getModel().getTaskList().getTask(i).toString());
        }
    }
    public void displayScheduledTasks(){
        int counter = 1;
        for(int i = 0; i < mainController.getModel().getTaskList().size(); i++) {
            if(mainController.getModel().getTaskList().getTask(i).isScheduled(new Date())){
                System.out.println((counter++) + "." + mainController.getModel().getTaskList().getTask(i).toString());
            }
        }
        PrintMenu.printMainMenu();
    }
    public void remove(){
        String remover = "Write the index of the task to remove it from your list.";
        System.out.println(remover);
        this.displayTasksForRemoving();
        mainController.remove();
    }

    public void repeatTasks() {
        System.out.println("Enter:");
        System.out.println("Title");
        System.out.println("Time of a new task hh:mm:ss dd/MM/yyyy");
        System.out.println("Task end time hh:mm:ss dd/MM/yyyy");
        System.out.println("Set an interval in seconds");
        mainController.menuOfAddingRepeatedTasks();
    }

    public void norepeat(){
        System.out.println("Enter:");
        System.out.println("Title");
        System.out.println("Time hh:mm:ss dd/MM/yyyy");
        mainController.menuOfNoRepeatTasks();
    }

    public void active(){
        displayTasksForRemoving();
        System.out.println("Choose the task: ");
        mainController.active();
    }
    public void ret(){
        System.out.println("Returning back");
        PrintMenu.printMainMenu();
    }
    public void title(){
        displayTasksForRemoving();
        System.out.println("Write a new title of your task");
        System.out.println("Choose the index of the task");
        mainController.title();
    }
    public void time(){
        displayTasksForRemoving();
        System.out.println("Set the time hh:mm:ss dd/MM/yyyy");
        System.out.println("Choose the index of your task:");
        mainController.time();
    }
    public void exec(){
        displayTasksForRemoving();
        System.out.println("Firstly choose the taks beforehand and enter:");
        System.out.println("Start time hh:mm:ss dd/MM/yyyy");
        System.out.println("End time hh:mm:ss dd/MM/yyyy");
        System.out.println("Interval");
        System.out.println("Index of the task");
        mainController.exec();
    }
}
