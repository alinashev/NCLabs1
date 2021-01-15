package com.company;

public interface Observable {
    void registerUsers(Observer observer);
    void notifyAllUsers();
}
