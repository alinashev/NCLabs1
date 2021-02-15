package com.company.controller.action.mainMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.PrintMenu;
import com.company.view.View;

public class CreateNewTask implements Action {
    private View view;
    /**
     * Instantiates a new Create new task.
     *
     * @param view the view object
     */
    public CreateNewTask(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        PrintMenu printMenu = new PrintMenu();
        printMenu.setMenuController(controller);
        printMenu.printCreateTask();
    }
}