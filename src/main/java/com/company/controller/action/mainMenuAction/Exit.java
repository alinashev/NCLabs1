package com.company.controller.action.mainMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class Exit implements Action {

    @Override
    public void execute(MenuController controller) {
        controller.exitApp();
    }
}
