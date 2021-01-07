package com.company.controller;

import com.company.controller.action.Action;
import com.company.controller.action.addMenuAction.*;
import com.company.controller.action.mainMenuAction.CreateNewTask;
import com.company.controller.action.mainMenuAction.*;
import com.company.view.Notification;
import com.company.view.PrintMenu;

import java.util.HashMap;
import java.util.Map;

public class MenuController {
    private PrintMenu printMenu;
    private Notification notification = new Notification();
    private Map<Integer, Action> menu = new HashMap<>();
    private Map<Integer, Action> addMenu = new HashMap<>();

     public MenuController(PrintMenu printMenu){
         this.printMenu = printMenu;
     }

     public void fillMaps(){
         menu.put(1, new CreateNewTask());
         menu.put(2, new EditTask());
         menu.put(3, new RemoveTask());
         menu.put(4, new ShowCurrentTasks());
         menu.put(5, new ShowScheduledTasks());
         menu.put(6, new Exit());

         addMenu.put(1, new AddRepeatedTask());
         addMenu.put(2, new AddNotRepeatedTask());
         addMenu.put(3, new BackToMainMenu());
     }

     public void chooseMainMenuOption(int choice){
         if (choice > 0 & choice <= menu.size()){
             menu.get(choice).execute(this);
         }else {
             notification.wrongInput();
             chooseMainMenuOption(new InputController().menuOption());
         }
     }

     public void exitApp(){
         notification.exitStatus();
         System.exit(0);
     }

    public PrintMenu getPrintMenu() {
        return printMenu;
    }
}
