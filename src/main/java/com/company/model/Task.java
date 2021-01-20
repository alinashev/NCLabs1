package com.company.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Task implements Cloneable, Serializable {
    private String title;
    private Date time;
    private Date start;
    private Date end;
    private int interval;
    private boolean active = true;
    private boolean noRepeated;

    public Task(String title, Date time){
        if(time != null) {
            this.title = title;
            this.time = time;
            noRepeated = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Task(String title, Date start, Date end, int interval){
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


    public Date getTime(){
        if(isRepeated()) return start;
        else return time;
    }

    public void setTime(Date time) {
        this.time = time;
        if(isRepeated()) noRepeated = true;
    }

    public Date getStartTime() {
        if(!isRepeated()) return time;
        else return start;
    }

    public Date getEndTime() {
        if(!isRepeated()) return time;
        else return end;
    }

    public int getRepeatInterval() {
        if (!isRepeated()) return 0;
        else return interval;
    }

    public void setTime(Date start, Date end, int interval){
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

    public Date nextTimeAfter(Date current){
        if (active) {
            if (noRepeated) {
                if (time.after(current)) {
                    return time;
                } else {
                    return null;
                }
            } else {
                Date hold = (Date) start.clone();
                while (hold.before(current) || hold.equals(current)) {
                    hold.setTime(hold.getTime() + interval * 1000);
                }
                if (hold.after(end)) {
                    return null;
                } else {
                    return hold;
                }
            }
        } else {
            return null;
        }
    }
    public boolean isScheduled(Date current){
        if(noRepeated){
            return time.after(current);
        }else {
            return end.after(current);
        }
    }

    @Override
    public String toString() {
        return "Task{" +
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
