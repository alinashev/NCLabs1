package com.company.controller.action.mainMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class ShowScheduledTasks implements Action {
    private View view;
    /**
     * Instantiates a new Show scheduled tasks.
     *
     * @param view the view object
     */
    public ShowScheduledTasks(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.displayScheduledTasks();
    }
}
