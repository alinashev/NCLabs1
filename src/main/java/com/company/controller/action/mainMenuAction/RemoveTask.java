package com.company.controller.action.mainMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class RemoveTask implements Action {
    private View view;
    /**
     * Instantiates a new Remove task.
     *
     * @param view the view object
     */
    public RemoveTask(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.remove();
    }
}
