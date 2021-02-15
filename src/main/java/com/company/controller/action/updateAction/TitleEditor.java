package com.company.controller.action.updateAction;

import com.company.controller.MenuController;
import com.company.controller.action.Action;
import com.company.view.View;

public class TitleEditor implements Action {
    private View view;
    /**
     * Instantiates a new Title editor.
     *
     * @param view the view object
     */
    public TitleEditor(View view) {
        this.view = view;
    }
    @Override
    public void execute(MenuController controller) {
        view.title();
    }
}
