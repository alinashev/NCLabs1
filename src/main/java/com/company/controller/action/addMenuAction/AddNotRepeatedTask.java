package com.company.controller.action.addMenuAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class AddNotRepeatedTask implements Action {
    private View view;
    /**
     * Instantiates a new Add not repeated task.
     *
     * @param view the view object
     */
    public AddNotRepeatedTask(View view) {
        this.view = view;
    }

    @Override
    public void execute(MenuController controller) {
        view.norepeat();
    }
}
