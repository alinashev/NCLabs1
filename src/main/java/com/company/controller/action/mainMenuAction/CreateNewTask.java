package com.company.controller.action.mainMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;

public class CreateNewTask implements Action {
    @Override
    public void execute(MenuController controller) {
        controller.getPrintMenu().printCreateTask();

    }
}
