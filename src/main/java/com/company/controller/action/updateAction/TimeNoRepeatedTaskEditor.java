package com.company.controller.action.updateAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class TimeNoRepeatedTaskEditor implements Action {
    private View view;

    public TimeNoRepeatedTaskEditor(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.time();
    }
}