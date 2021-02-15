package com.company.controller.action.mainMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.PrintMenu;
import com.company.view.View;

public class EditTask implements Action {
    private View view;
    /**
     * Instantiates a new Edit task.
     *
     * @param view the view object
     */
    public EditTask(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        PrintMenu.printChangeTasks();
    }
}