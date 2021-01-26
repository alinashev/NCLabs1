package com.company.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList implements Cloneable {
    private Task[] tasksList = {};

    @Override
    public void add(Task task){
        tasksList = Arrays.copyOf(tasksList, tasksList.length + 1);
        tasksList [tasksList.length- 1] = task;
    }

    @Override
    public boolean remove(Task task){
        boolean removed = false;
        for (int i = 0; i < tasksList.length; i++){
            if(task == tasksList[i]){
                removed = true;
                tasksList[i] = null;
                break;
            }
        }
        if(removed) {
            Task[] tempList = new Task[tasksList.length - 1];
            int j = 0;
            for (int i = 0; i < tasksList.length; i++) {
                if (tasksList[i] != null) {
                    tempList[j] = tasksList[i];
                    j++;
                }
            }
            tasksList = tempList;
        }
        return removed;
    }
    @Override
    public int size(){
        return tasksList.length;
    }

    @Override
    public Task getTask(int index){
        if(index < tasksList.length && index >= 0) {
            return tasksList[index];
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Stream<Task> getStream() {
        return Arrays.stream(this.tasksList);
    }

    @Override
    public Iterator<Task> iterator() {
        return new ArrayIterator(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        return Arrays.equals(tasksList, that.tasksList);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + ((tasksList != null) ? tasksList.hashCode() : 0);
        return hash;
    }


    @Override
    public ArrayTaskList clone() {
        ArrayTaskList arrayTaskList = new ArrayTaskList();

        for(int i = 0; i < size(); i++){
            arrayTaskList.add(this.tasksList[i]);
        }
        return arrayTaskList;
    }

    @Override
    public String toString() {
        return Arrays.toString(tasksList);
    }

}
