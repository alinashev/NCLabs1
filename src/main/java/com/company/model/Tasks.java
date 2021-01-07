package com.company.model;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {
    
    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime from, LocalDateTime to) {

        LinkedList<Task> subtaskList = new LinkedList<>();
        LocalDateTime nextTime;

        for(Task current : tasks) {
            nextTime = current.nextTimeAfter(from);
            if(nextTime != null && !nextTime.isAfter(to)) {
                subtaskList.add(current);
            }
        }
        return subtaskList;
    }

    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {
        if(tasks == null || start == null || end == null){
            throw new IllegalArgumentException();
        }
        TreeMap<LocalDateTime, Set<Task>> calendar = new TreeMap<>();
        LocalDateTime startTime;
        Set<Task> setTasks;

        for(Task tempTask : incoming(tasks, start, end)) {
            startTime = start;
            while (true) {
                startTime = tempTask.nextTimeAfter(startTime);
                if(startTime == null || startTime.isAfter(end)) {
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
