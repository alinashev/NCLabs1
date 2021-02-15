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

    /**
     * Instantiates a new Task (not repeated).
     *
     * @param title the title
     * @param time  the time
     */
    public Task(String title, Date time){
        if(time != null) {
            this.title = title;
            this.time = time;
            noRepeated = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Instantiates a new Task (repeated).
     *
     * @param title    the title
     * @param start    the start date
     * @param end      the end date
     * @param interval the interval
     */
    public Task(String title, Date start, Date end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    /**
     * Get title string.
     *
     * @return the string
     */
    public String getTitle(){
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive(){
        return active;
    }

    /**
     * Set active.
     *
     * @param active the active
     */
    public void setActive(boolean active){
        this.active = active;
    }


    /**
     * Get time date.
     *
     * @return the date
     */
    public Date getTime(){
        if(isRepeated()) return start;
        else return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Date time) {
        this.time = time;
        if(isRepeated()) noRepeated = true;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public Date getStartTime() {
        if(!isRepeated()) return time;
        else return start;
    }

    /**
     * Gets end time.
     *
     * @return the end time
     */
    public Date getEndTime() {
        if(!isRepeated()) return time;
        else return end;
    }

    /**
     * Gets repeat interval.
     *
     * @return the repeat interval
     */
    public int getRepeatInterval() {
        if (!isRepeated()) return 0;
        else return interval;
    }

    /**
     * Set time.
     *
     * @param start    the start date
     * @param end      the end date
     * @param interval the interval
     */
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

    /**
     * Is repeated boolean.
     *
     * @return the boolean
     */
    public boolean isRepeated(){
        return !noRepeated;
    }

    /**
     * Next time after given date.
     *
     * @param current the current
     * @return the date
     */
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

    /**
     * Is scheduled boolean.
     *
     * @param current the current
     * @return the boolean
     */
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
