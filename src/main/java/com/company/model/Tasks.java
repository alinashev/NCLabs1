package com.company.model;

import java.util.*;

public class Tasks {

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
