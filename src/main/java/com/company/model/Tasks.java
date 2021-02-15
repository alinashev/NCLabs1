package com.company.model;

import java.util.*;

public class Tasks {

    /**
     *  Checking of incoming task.
     *
     * @param tasks the tasks
     * @param from  the from
     * @param to    the to
     * @return the iterable
     */
    public static Iterable<Task> incoming(Iterable<Task> tasks, Date from, Date to) {

        LinkedList<Task> subtaskList = new LinkedList<>();
        Date nextTime;

        for(Task current : tasks) {
            nextTime = current.nextTimeAfter(from);
            if(nextTime != null && !nextTime.after(to)) {
                subtaskList.add(current);
            }
        }
        return subtaskList;
    }

    /**
     * Method returns the calendar.
     *
     * @param tasks the tasks
     * @param start the start
     * @param end   the end
     * @return the sorted map
     */
    public static SortedMap<Date, Set<Task>> calendar(Iterable<Task> tasks, Date start, Date end) {
        if(tasks == null || start == null || end == null){
            throw new IllegalArgumentException();
        }
        TreeMap<Date, Set<Task>> calendar = new TreeMap<>();
        Date startTime;
        Set<Task> setTasks;

        for(Task tempTask : incoming(tasks, start, end)) {
            startTime = start;
            while (true) {
                startTime = tempTask.nextTimeAfter(startTime);
                if(startTime == null || startTime.after(end)) {
                    break;
                }
                if(calendar.containsKey(startTime)) {
                    setTasks = calendar.get(startTime);
                } else {
                    setTasks = new HashSet<>();
                    calendar.put(startTime, setTasks);
                }
                setTasks.add(tempTask);
            }
        }
        return calendar;
    }
}
