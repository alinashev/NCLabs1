package com.company.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList {
    private Node first;
    private Node last;
    private int size;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    @Override
    public void add(Task task){
        Node newNode = new Node(task);
        if (first == null) {
            newNode.setNext(null);
            newNode.setPrevious(null);
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Task task) {
        Node current = first;
        Node previous = null;

        while (current != null) {
            if (current.getElement().equals(task)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                    if (current.getNext() == null) {
                        last = previous;
                    }
                } else {
                    first = first.getNext();
                    if (first == null) {
                        last = null;
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Task getTask(int index){
        Node node = first;
        if (index == 0){
            return node.getElement();
        }else {
            if (node.getNext() != null) {
                for(int i = 0; i < index; i++){
                    node = node.getNext();
                }
                return node.getElement();
            }else {
                return null;
            }
        }
    }

    @Override
    public Stream<Task> getStream() {
        List<Task> listOfTask = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            listOfTask.add(this.getTask(i));
        }
        return listOfTask.stream();
    }

    @Override
    public Iterator<Task> iterator() {
        return new LinkedIterator(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList that = (LinkedTaskList) o;
        if(this.size() == that.size()){
            for (int i = 0; i < that.size(); i++){
                if(!this.getTask(i).equals(that.getTask(i))){
                    return false;
                }
            }
        }
        else return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, size);
    }
    @Override
    public LinkedTaskList clone() {
        LinkedTaskList linkedTaskList = new LinkedTaskList();

        for(int i = 0; i < size(); i++){
            linkedTaskList.add(this.getTask(i));
        }
        return linkedTaskList;
    }
}
