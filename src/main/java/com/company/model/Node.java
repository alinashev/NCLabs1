package com.company.model;

import java.util.Objects;

public class Node {
    private Task element;
    private Node next;
    private Node previous;

    public Node(Task element) {
        this.element = element;
    }

    public Node() {}

    public Node(Task element, Node next, Node previous){
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public Task getElement() {
        return element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(element, node.element) && Objects.equals(next, node.next) && Objects.equals(previous, node.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, next, previous);
    }
}