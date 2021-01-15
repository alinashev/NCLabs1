package com.company.controller.action.addMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class BackToMainMenu implements Action {
    private View view;

    public BackToMainMenu(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.ret();
    }
}
