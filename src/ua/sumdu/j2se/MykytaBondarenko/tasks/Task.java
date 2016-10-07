package ua.sumdu.j2se.MykytaBondarenko.tasks;

public class Task {
    private String title;
    private boolean active;
    private int time;
    private int startTime;
    private int endTime;
    private int repeatInterval;
    private boolean repeated;

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        active = false;
        repeated = false;
    }

    public Task(String title, int start, int end, int interval) {
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

    public void setTime(int time) {
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

    public void setTime(int start, int end, int interval) {
        startTime = start;
        endTime = end;
        repeatInterval = interval;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public int nextTimeAfter(int current) {
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

}

