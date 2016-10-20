package ua.sumdu.j2se.MykytaBondarenko.tasks;

import java.io.Serializable;

public class Task implements Serializable{
    private String title;
    private boolean active;
    private int time;
    private int startTime;
    private int endTime;
    private int repeatInterval;
    private boolean repeated;

    public Task(String title, int time) throws IllegalArgumentException {
        if (time < 0) {
            throw new IllegalArgumentException("Time must be not negative");
        }

        this.title = title;
        this.time = time;
        active = false;
        repeated = false;
    }

    public Task(String title, int start, int end, int interval) throws IllegalArgumentException {
        if (start < 0 || end < 0 || end <= start) {
            throw new IllegalArgumentException("Start and end parameters must be not negative and end > start");
        }
        if (interval <= 0) {
            throw new IllegalArgumentException("Interval must be a positive");
        }

        this.title = title;
        startTime = start;
        endTime = end;
        repeatInterval = interval;
        active = false;
        repeated = true;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) throws IllegalArgumentException {
        if (time < 0) {
            throw new IllegalArgumentException("Time must be not negative");
        }

        this.time = time;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getRepeatInterval() {
        return repeatInterval;
    }

    public void setTime(int start, int end, int interval) throws IllegalArgumentException {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Start and end parameters must be not negative");
        }
        if (interval <= 0) {
            throw new IllegalArgumentException("Interval must be a positive");
        }

        startTime = start;
        endTime = end;
        repeatInterval = interval;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public int nextTimeAfter(int current) throws IllegalArgumentException {
        if (current < 0) {
            throw new IllegalArgumentException("Current time must be not negative");
        }

        if (active) {
            if (!repeated && time > current) {
                return time;
            }
            if(repeated && endTime > current) {
                if(startTime > current) {
                    return startTime;
                }
                //Find amount of executed repeating, add 1 and convert to time
                return  startTime + ((current - startTime)/repeatInterval + 1)*repeatInterval;
            }
        }
        return  -1;
    }

    public boolean equals(Task task) {
        if (task == null) {
            return false;
        }
        return title == task.title &&
                active == task.active &&
                time == task.time &&
                startTime == task.startTime &&
                endTime == task.endTime &&
                repeatInterval == task.repeatInterval &&
                repeated == task.repeated;
    }

    public int hashCode() {
        return title.hashCode() + (isActive()? 1:0) + (isRepeated()? startTime + endTime + repeatInterval : 0);
    }

    @Override
    public String toString() {
        return title + (isActive()? " Active " : " Not active ");
    }
}

