package ua.sumdu.j2se.MykytaBondarenko.tasks;

public class Task {
    private String title;
    private boolean active;
    private int time;
    private int startTime;
    private int endTime;
    private int repeatInterval;
    private boolean repeated;

    Task(String title, int time) {
        this.title = title;
        this.time = time;
        active = false;
    }

    Task(String title, int start, int end, int interval) {
        this.title = title;
        startTime = start;
        endTime = end;
        repeatInterval = interval;
        active = false;
    }
    
    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    boolean isActive() {
        return active;
    }

    void setActive(boolean active) {
        this.active = active;
    }

    int getTime() {
        return time;
    }

    void setTime(int time) {
        this.time = time;
    }

    int getStartTime() {
        return startTime;
    }

    int getEndTime() {
        return endTime;
    }

    int getRepeatInterval() {
        return repeatInterval;
    }

    void setTime(int start, int end, int interval) {
        startTime = start;
        endTime = end;
        repeatInterval = interval;
    }

    boolean isRepeated() {
        return repeated;
    }

    int nextTimeAfter(int current) {
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

