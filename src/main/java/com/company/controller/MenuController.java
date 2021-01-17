package com.company.controller;

import com.company.controller.action.Action;
import com.company.controller.action.addMenuAction.*;
import com.company.controller.action.mainMenuAction.CreateNewTask;
import com.company.controller.action.mainMenuAction.*;
import com.company.controller.action.updateAction.ActivityEditor;
import com.company.controller.action.updateAction.TimeNoRepeatedTaskEditor;
import com.company.controller.action.updateAction.TimeRepeatedTaskEditor;
import com.company.controller.action.updateAction.TitleEditor;
import com.company.view.Notification;
import com.company.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuController {
    private MainController mainController;
    private MenuController menuController;
    private View view;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    private Map<Integer, Action> menu = new HashMap<>();
    private Map<Integer, Action> addMenu = new HashMap<>();
    private Map<Integer, Action> changeTask = new HashMap<>();

    public void fillMaps(){
        menu.put(1, new CreateNewTask(view));
        menu.put(2, new EditTask(view));
        menu.put(3, new RemoveTask(view));
        menu.put(4, new ShowCurrentTasks(view));
        menu.put(5, new ShowScheduledTasks(view));
        menu.put(6, new Exit());

        addMenu.put(1, new AddRepeatedTask(view));
        addMenu.put(2, new AddNotRepeatedTask(view));
        addMenu.put(3, new BackToMainMenu(view));

        changeTask.put(1, new TimeNoRepeatedTaskEditor(view));
        changeTask.put(2, new TimeRepeatedTaskEditor(view));
        changeTask.put(3, new TitleEditor(view));
        changeTask.put(4, new ActivityEditor(view));
        changeTask.put(5, new BackToMainMenu(view));
    }

    public void chooseMainMenuOption(int choice){
        if (choice > 0 & choice <= menu.size()){
            menu.get(choice).execute(this);
        }else {
            Notification.wrongInput();
            chooseMainMenuOption(new InputController().menuOption());
        }
    }
    public void chooseTaskType(int choice){
        if (choice > 0 & choice <= addMenu.size()){
            addMenu.get(choice).execute(this);
        }else {
            Notification.wrongInput();
            chooseMainMenuOption(new InputController().menuOption());
        }
    }
    public void chooseEditOption(int choice){
        if (choice > 0 & choice <= changeTask.size()){
            changeTask.get(choice).execute(this);
        }else {
            Notification.wrongInput();
            chooseEditOption(new InputController().menuOption());
        }
    }
    public void exitApp(){
        Notification.exitStatus();
        System.exit(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuController)) return false;
        MenuController that = (MenuController) o;
        return Objects.equals(mainController, that.mainController) &&
                Objects.equals(menuController, that.menuController) &&
                Objects.equals(view, that.view) &&
                Objects.equals(menu, that.menu) &&
                Objects.equals(addMenu, that.addMenu) &&
                Objects.equals(changeTask, that.changeTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainController, menuController, view, menu, addMenu, changeTask);
    }
}
