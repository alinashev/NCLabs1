package com.company.view;

public class PrintMenu extends View {

    public void printMainMenu(){
        System.out.println("1 - Create new task");
        System.out.println("2 - Edit task");
        System.out.println("3 - Remove task");
        System.out.println("4 - Show current tasks");
        System.out.println("5 - Show scheduled tasks");
        System.out.println("6 - Exit");
    }
    public void printCreateTask(){
        System.out.println("1 - Repeated");
        System.out.println("2 - Not repeated");
        System.out.println("3 - Back");
    }
}
