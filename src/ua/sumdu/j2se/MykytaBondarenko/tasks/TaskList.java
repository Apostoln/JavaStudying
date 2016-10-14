package ua.sumdu.j2se.MykytaBondarenko.tasks;

public abstract class TaskList {
    public abstract void add(Task task) throws NullPointerException;

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index) throws IllegalArgumentException;

    public abstract TaskList incoming(int from, int to) throws IllegalArgumentException;
}
