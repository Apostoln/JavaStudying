package ua.sumdu.j2se.MykytaBondarenko.tasks;

import java.util.Iterator;

public abstract class TaskList implements Iterable <Task> {

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
}
