package com.company.controller.action;

import com.company.controller.MenuController;

public interface Action {
     /**
      * Execute.
      * This method should be overridden according to the pattern "Action/Command"
      *
      * @param controller the controller object
      */
     void execute(MenuController controller);
}
