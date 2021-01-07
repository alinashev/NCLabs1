package com.company.model;

import java.io.Serializable;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable, Serializable {

    protected abstract void add(Task task);

    protected abstract boolean remove(Task task);

    protected abstract int size();

    protected abstract Task getTask(int index);

    public abstract Stream<Task> getStream();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
