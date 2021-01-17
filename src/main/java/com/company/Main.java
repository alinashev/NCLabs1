package com.company;

import com.company.controller.InputController;
import com.company.controller.MainController;
import com.company.controller.MenuController;
import com.company.view.OSNotification;
import com.company.model.Model;
import com.company.view.Notification;
import com.company.view.PrintMenu;
import com.company.view.View;
import org.apache.log4j.BasicConfigurator;

public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Model model = new Model();
        Notification notification = new Notification();
        View view = new View();

        MainController mainController = new MainController();
        mainController.setModel(model);
        mainController.setErrorView(notification);

        MenuController menuController = new MenuController();
        view.setMainController(mainController);
        menuController.setMainController(view.getMainController());
        menuController.setView(view);
        menuController.fillMaps();

        OSNotification osn = new OSNotification(model);
        osn.start();

        PrintMenu printMenu = new PrintMenu();
        printMenu.setMenuController(menuController);
        model.readFile();
        view.register();
        PrintMenu.printMainMenu();
        menuController.chooseMainMenuOption(new InputController().menuOption());
    }
}
