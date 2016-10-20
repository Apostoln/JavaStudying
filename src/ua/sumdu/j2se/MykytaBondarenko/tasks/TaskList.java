package ua.sumdu.j2se.MykytaBondarenko.tasks;

import java.io.Serializable;
import java.util.Iterator;

public abstract class TaskList implements Iterable <Task>, Serializable {

    public TaskList() {}
    public abstract Iterator <Task> iterator();

    public abstract void add(Task task) throws NullPointerException;

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index) throws IllegalArgumentException;

    public TaskList incoming(int from, int to) {
        if (from >= to || from < 0 || to < 0) {
            throw new IllegalArgumentException("Time must be not negative and from < to");
        }
        TaskList result = null;
        try {
            result = this.getClass().newInstance();
        }
        catch (InstantiationException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        for (Task task : this) {
            if (task.isRepeated()) {
                if (task.nextTimeAfter(from) <= to) {
                    result.add(task);
                }
            } else {
                if (task.getTime() >= from && task.getTime() <= to) {
                    result.add(task);
                }
            }
        }
        return result;
    }

    public boolean equals(TaskList other) {
        if(other.size() != this.size()) {
            return false;
        }
        Iterator<Task> first = other.iterator();
        Iterator<Task> second = this.iterator();
        while(first.hasNext()) {
            Task firstTask = first.next();
            Task secondTask = second.next();
            if (firstTask != secondTask) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = this.size();
        int hashsum = 0;
        for(Task task: this) {
            hashsum += task.hashCode();
        }
        return size + hashsum;
    }

    @Override
    public String toString() {
        return getClass().getName() + " with " + size() + " elements ";
    }
}
