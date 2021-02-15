package com.company.controller;

import com.company.model.Model;
import com.company.model.Task;
import com.company.view.Notification;
import com.company.view.PrintMenu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainController {
    private Model model;
    private Notification errorView;
    public void setErrorView(Notification errorView){
        this.errorView = errorView;
    }
    SimpleDateFormat ft = new SimpleDateFormat ("HH:mm dd/MM/yyyy");

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Printer string waiting for input string from users's console and returns the same one.
     *
     * @return the string
     */
    public String printer (){
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    /**
     * Menu of no repeat tasks.
     * Method reads title, time, date of not repeated task, and converts according to the date pattern.
     */
    public void menuOfNoRepeatTasks() {
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        String time = input.nextLine();
        String date = input.nextLine();
        try{
            Date timen = ft.parse(time + " " + date);
            Task tsk = new Task(title,timen);
            model.addTaskNoRepeat(tsk);
        }catch(Exception e){
            e.printStackTrace();
            errorView.logEr();
            menuOfNoRepeatTasks();
        }
    }

    /**
     * Menu of adding repeated tasks.
     * Method reads title, start time, start date, ent time, end date of  repeated task,
     * and converts according to the date pattern.
     */
    public void menuOfAddingRepeatedTasks()  {
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        String dateStrTime = in.nextLine();
        String dateStrDate = in.nextLine();
        String dateEndTime = in.nextLine();
        String dateEndDate= in.nextLine();
        int interval = in.nextInt();
        try {
            Date time = ft.parse(dateStrTime + " " + dateStrDate);
            Date end =  ft.parse(dateEndTime + " " + dateEndDate);
            Task tsk = new Task(title,time,end,interval);
            model.addTask(tsk);
        } catch (Exception e) {
            errorView.logEr();
            this.menuOfAddingRepeatedTasks();
        }
    }

    /**
     * Remove method reads an index of the task from given list and removes one.
     */
    public void remove() {
        Scanner rin = new Scanner(System.in);
        int index = rin.nextInt();
        try{
            model.removeTask(index);

        }catch (Exception e){
            errorView.logEr();
            PrintMenu.printMainMenu();
        }
    }

    /**
     * Active method changes an activity of given task.
     */
    public void active(){
        Scanner active = new Scanner(System.in);
        int index = active.nextInt();
        if(index <= model.getTaskList().size() && index > 0) {
            model.active(index);
        }else{
            errorView.logEr();
            active();
        }

    }

    /**
     * Exec method changes time and date of repeated task.
     */
    public void exec(){
        Scanner scanner = new Scanner(System.in);
        String startTime = scanner.nextLine();
        String startDate = scanner.nextLine();
        String endTime = scanner.nextLine();
        String endDate = scanner.nextLine();
        int interval = scanner.nextInt();
        int index = scanner.nextInt();
        try{
            Date starter = ft.parse(startTime + " " + startDate);
            Date ender = ft.parse(endTime + " " + endDate);
            model.changeTime(index,starter,ender,interval);
        }catch (Exception e){
            errorView.logEr();
            exec();
        }

    }

    /**
     * Time method changes time and date of not repeated task.
     */
    public void time(){
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        String date = scanner.nextLine();
        int index = scanner.nextInt();
        try{
            Date timer = ft.parse(time + " " + date);
            model.time(timer,index);
        }catch (Exception e){
            errorView.logEr();
            time();
        }

    }

    /**
     * Title method changes the title of given task.
     */
    public void title(){
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        int index = scanner.nextInt();
        model.title(title,index);
    }
}
