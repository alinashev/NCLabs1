package com.company.controller;

import com.company.model.Model;
import com.company.model.Task;
import com.company.view.Notification;
import com.company.view.PrintMenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainController {
    private Model model;
    private Notification errorView;
    public void setErrorView(Notification errorView){
        this.errorView = errorView;
    }
    DateTimeFormatter dft = DateTimeFormatter.ofPattern ("ss:mm:HH dd/MM/yyyy");
    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public String printer (){
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    public void menuOfNoRepeatTasks() {
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        String time = input.nextLine();
        try{
            LocalDateTime timen = LocalDateTime.parse(time,dft);
            Task tsk = new Task(title,timen);
            model.addTaskNoRepeat(tsk);
        }catch(Exception e){
            e.printStackTrace();
            errorView.logEr();
            menuOfNoRepeatTasks();
        }
    }
    public void menuOfAddingRepeatedTasks()  {
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        String dateStr = in.nextLine();
        String dateEnd = in.nextLine();
        int interval = in.nextInt();
        try {
            LocalDateTime time = LocalDateTime.parse(dateStr,dft);
            LocalDateTime end =  LocalDateTime.parse(dateEnd,dft);
            Task tsk = new Task(title,time,end,interval);
            model.addTask(tsk);
        } catch (Exception e) {
            errorView.logEr();
            this.menuOfAddingRepeatedTasks();
        }
    }
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
    public void active(){
        Scanner active = new Scanner(System.in);
        int index = active.nextInt();
        if(index < model.getTaskList().size() && index > 0) {
            model.active(index);
        }else{
            errorView.logEr();
            active();
        }

    }
    public void exec(){
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String end = scanner.nextLine();
        int interval = scanner.nextInt();
        int index = scanner.nextInt();
        try{
            LocalDateTime starter = LocalDateTime.parse(start,dft);
            LocalDateTime ender = LocalDateTime.parse(end,dft);
            model.changeTime(index,starter,ender,interval);
        }catch (Exception e){
            errorView.logEr();
            exec();
        }

    }
    public void time(){
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        int index = scanner.nextInt();
        try{
            LocalDateTime timer = LocalDateTime.parse(time,dft);
            model.time(timer,index);
        }catch (Exception e){
            errorView.logEr();
            time();
        }

    }
    public void title(){
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        int index = scanner.nextInt();
        model.title(title,index);
    }
}
