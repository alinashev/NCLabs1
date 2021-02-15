package com.company.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import com.company.Observable;
import com.company.Observer;
import org.apache.log4j.Logger;

public class Model implements Observable {
    private ArrayTaskList taskList = new ArrayTaskList();
    private ArrayList<Observer> observers = new ArrayList<>();
    public static Logger logger = Logger.getLogger(Model.class);
    public ArrayTaskList getTaskList() {
        return taskList;
    }

    /**
     * Saving data method saves the list of tasks to the file.
     */
    public void savingData(){
        try {
            TaskIO.writeText(taskList,new File(Constants.FILE_PATH));
            notifyAllUsers();
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Read file method reads all tasks from given text file.
     */
    public void readFile(){
        try {
            TaskIO.readText(taskList,new File(Constants.FILE_PATH));
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Add task method adds a new task to the list.
     *
     * @param task the task
     */
    public void addTask(Task task){
        taskList.add(task);
        savingData();
    }

    /**
     * Remove task method removes a task from the list.
     *
     * @param index the index
     */
    public void removeTask(int index){
        taskList.remove(taskList.getTask(index-1));
        savingData();
    }

    /**
     * Active method changes task from the list.
     *
     * @param index the index
     */
    public void active(int index) {
        taskList.getTask(index-1).setActive(!taskList.getTask(index-1).isActive());
        savingData();

    }

    /**
     * Add task no repeat method adds new task(not repeated) to the list.
     *
     * @param task the task
     */
    public void addTaskNoRepeat(Task task){
        taskList.add(task);
        savingData();

    }

    /**
     * Change time method changes time of repeated task.
     *
     * @param index    the index of task from list
     * @param starter  start time and date of the task
     * @param ender    end time and date of the task
     * @param interval the interval of executing task
     */
    public void changeTime(int index, Date starter, Date ender, int interval){
        taskList.getTask(index-1).setTime(starter,ender,interval);
        savingData();
    }

    /**
     * Title method changes the title of the task from list.
     *
     * @param title a new title
     * @param index the index of selected task
     */
    public void title(String title, int index){
        taskList.getTask(index-1).setTitle(title);
        savingData();
    }

    /**
     * Time method changes time of the task from list;
     *
     * @param timer new time and date of task
     * @param index the index of selected task
     */
    public void time(Date timer, int index ){
        taskList.getTask(index-1).setTime(timer);
        savingData();
    }

    @Override
    public void registerUsers(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllUsers() {
        for(int i = 0; i < observers.size();i++){
            observers.get(i).update();
        }
    }
}
