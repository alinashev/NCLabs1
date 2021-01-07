package com.company.model;


public class TaskListFactory {
   public static AbstractTaskList createTaskList(ListTypes.type type){
        if(type == ListTypes.type.ARRAY){
            return new ArrayTaskList();
        }
        else return new LinkedTaskList();
    }
}
