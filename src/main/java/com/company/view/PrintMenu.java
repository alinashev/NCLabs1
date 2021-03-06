package com.company.view;

import com.company.controller.InputController;
import com.company.controller.MenuController;

public class PrintMenu {
    private static MenuController menuController;

    /**
     * Gets menu controller.
     *
     * @return the menu controller object
     */
    public MenuController getMenuController() {
        return menuController;
    }

    /**
     * Sets menu controller.
     *
     * @param menuController the menu controller
     */
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    /**
     * Method prints main menu.
     */
    public static void printMainMenu(){
        System.out.println("1 - Create new task");
        System.out.println("2 - Edit task");
        System.out.println("3 - Remove task");
        System.out.println("4 - Show current tasks");
        System.out.println("5 - Show scheduled tasks");
        System.out.println("6 - Exit");
        menuController.chooseMainMenuOption(new InputController().menuOption());

    }

    /**
     * Method prints selection of repeated/not repeated task.
     */
    public void printCreateTask(){
        System.out.println("1 - Repeated");
        System.out.println("2 - Not repeated");
        System.out.println("3 - Back");
        menuController.chooseTaskType(new InputController().menuOption());
    }

    /**
     * Method prints the menu of changing task.
     */
    public static void printChangeTasks(){
        System.out.println("Please, enter the number of tasks (Change)");
        System.out.println("Choose the number 1 - 5 :");
        System.out.println("1 - Executing time of no repeating task");
        System.out.println("2 - Time of repeating task");
        System.out.println("3 - Title");
        System.out.println("4 - Activity");
        System.out.println("5 - Go back");
        menuController.chooseEditOption(new InputController().menuOption());
    }
}