package com.company.controller.action.updateAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class ActivityEditor implements Action {
    private View view;
    /**
     * Instantiates a new Activity editor.
     *
     * @param view the view object
     */
    public ActivityEditor(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.active();
    }
}
