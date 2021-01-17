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

    public void savingData(){
        try {
            TaskIO.writeText(taskList,new File("\\tasks.txt"));
            notifyAllUsers();
        } catch (Exception e) {
            logger.error(e);
        }
    }
    public void readFile(){
        try {
            TaskIO.readText(taskList,new File("\\tasks.txt"));
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void addTask(Task task){
        taskList.add(task);
        savingData();
    }
    public void removeTask(int index){
        taskList.remove(taskList.getTask(index-1));
        savingData();
    }

    public void active(int index) {
        taskList.getTask(index-1).setActive(!taskList.getTask(index-1).isActive());
        savingData();

    }
    public void addTaskNoRepeat(Task task){
        taskList.add(task);
        savingData();

    }
    public void changeTime(int index, Date starter, Date ender, int interval){
        taskList.getTask(index-1).setTime(starter,ender,interval);
        savingData();
    }
    public void title(String title, int index){
        taskList.getTask(index-1).setTitle(title);
        savingData();
    }

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
