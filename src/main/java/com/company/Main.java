package com.company;

import com.company.controller.InputController;
import com.company.controller.MenuController;
import com.company.view.PrintMenu;

public class Main {

    public static void main(String[] args) {
        PrintMenu printMenu = new PrintMenu();
        MenuController menuController = new MenuController(printMenu);
        menuController.fillMaps();
        printMenu.printMainMenu();
        menuController.chooseMainMenuOption(new InputController().menuOption());
    }
}
