package com.company;

public interface Observable {
    /**
     * Register users (subscribers).
     *
     * @param observer the observer object
     */
    void registerUsers(Observer observer);

    /**
     * Notify all users.
     */
    void notifyAllUsers();
}
