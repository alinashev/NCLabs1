package com.company.controller.action.addMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class AddRepeatedTask implements Action {
    private View view;

    public AddRepeatedTask(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.repeatTasks();
    }
}