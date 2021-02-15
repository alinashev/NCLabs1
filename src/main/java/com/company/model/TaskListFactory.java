package com.company.model;


public class TaskListFactory {
    /**
     * Create task list abstract task list.
     *
     * @param type the type
     * @return the abstract task list
     */
    public static AbstractTaskList createTaskList(ListTypes.type type){
        if(type == ListTypes.type.ARRAY){
            return new ArrayTaskList();
        }
        else return new LinkedTaskList();
    }
}
