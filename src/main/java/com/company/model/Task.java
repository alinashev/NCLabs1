package com.company.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Cloneable, Serializable {
    private String title;
    private LocalDateTime time;
    private LocalDateTime start;
    private LocalDateTime end;
    private int interval;
    private boolean active;
    private boolean noRepeated;

    public Task(String title, LocalDateTime time){
        if(time != null) {
            this.title = title;
            this.time = time;
            noRepeated = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Task(String title, LocalDateTime start, LocalDateTime end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }


    public LocalDateTime getTime(){
        if(isRepeated()) return start;
        else return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
        if(isRepeated()) noRepeated = true;
    }

    public LocalDateTime getStartTime() {
        if(!isRepeated()) return time;
        else return start;
    }

    public LocalDateTime getEndTime() {
        if(!isRepeated()) return time;
        else return end;
    }

    public int getRepeatInterval() {
        if (!isRepeated()) return 0;
        else return interval;
    }

    public void setTime(LocalDateTime start, LocalDateTime end, int interval){
        if(start == null || end == null){
            throw new IllegalArgumentException();
        }else{
            this.start = start;
            this.end = end;
            this.interval = interval;
            if(!isRepeated()) noRepeated = false;
        }

    }

    public boolean isRepeated(){
        return !noRepeated;
    }

    public LocalDateTime nextTimeAfter(LocalDateTime current){
        if(current == null){
            throw new IllegalArgumentException();
        }
        if(!isActive()){
            return null;
        }else{
            if(!isRepeated()){
                if(time.isAfter(current)){
                    return time;
                }
                else return null;
            }
            else{
                LocalDateTime timeSum = start;
                while(!current.isBefore(timeSum)){
                    timeSum = timeSum.plusSeconds(interval);
                }
                if(end.isBefore(timeSum)){
                    return null;
                }
                else return timeSum;
            }
        }
    }

    @Override
    public String toString() {
        return "com.company.model.Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                ", noRepeated=" + noRepeated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return time == task.time && start == task.start && end == task.end && interval == task.interval && active == task.active && noRepeated == task.noRepeated && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, active, noRepeated);
    }
    @Override
    public Task clone() throws CloneNotSupportedException {
        return (Task) super.clone();
    }
}
