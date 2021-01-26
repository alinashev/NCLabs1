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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
