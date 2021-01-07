package com.company.model;

import java.util.Iterator;
import java.util.Objects;

public class ArrayIterator implements Iterator<Task> {
    private int lastReturned = -1;

    private int current;
    private ArrayTaskList arrayTaskList;

    public ArrayIterator(ArrayTaskList arrayTaskList){
        this.arrayTaskList = arrayTaskList;
    }

    @Override
    public boolean hasNext() {
        return current != arrayTaskList.size();
    }

    @Override
    public Task next() {
        return arrayTaskList.getTask(lastReturned = current++);
    }

    @Override
    public void remove() {
        if(lastReturned >= 0){
            arrayTaskList.remove(arrayTaskList.getTask(lastReturned));
            current = lastReturned;
            lastReturned = -1;
        }else{
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayIterator that = (ArrayIterator) o;
        return lastReturned == that.lastReturned && current == that.current && Objects.equals(arrayTaskList, that.arrayTaskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastReturned, current, arrayTaskList);
    }
}
