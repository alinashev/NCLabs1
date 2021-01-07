package com.company.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedIterator implements Iterator<Task> {
    private LinkedTaskList linkedTaskList;

    private Node lastRet;
    private Node cursor;

    public LinkedIterator(LinkedTaskList linkedTaskList){
        this.linkedTaskList = linkedTaskList;
        lastRet = new Node(null,linkedTaskList.getFirst(),null);
        cursor = lastRet.getNext();
    }

    @Override
    public boolean hasNext() {
        return lastRet.getNext() != null;
    }

    @Override
    public Task next() {
        if(lastRet.getNext() != null){
            lastRet = cursor;
            cursor = cursor.getNext();
            return lastRet.getElement();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        if (lastRet.getElement() == null)
            throw new IllegalStateException();
        linkedTaskList.remove(lastRet.getElement());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedIterator that = (LinkedIterator) o;
        return Objects.equals(linkedTaskList, that.linkedTaskList) && Objects.equals(lastRet, that.lastRet) && Objects.equals(cursor, that.cursor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkedTaskList, lastRet, cursor);
    }
}
