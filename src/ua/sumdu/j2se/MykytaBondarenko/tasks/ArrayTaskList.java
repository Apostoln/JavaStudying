package ua.sumdu.j2se.MykytaBondarenko.tasks;

public class ArrayTaskList {
    private final int BASIC_SIZE = 5;
    private Task[] tasks = new Task[BASIC_SIZE];
    private int index = 0;

    public void add(Task task) throws NullPointerException {
        if (task == null) {
            throw new NullPointerException("Task is null");
        }

        if (index == tasks.length) {
            Task[] temp = tasks;
            tasks = new Task[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                tasks[i] = temp[i];
            }
        }
        tasks[index] = task;
        index++;
    }

    public boolean remove(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == task) {
                for (int j = i; j < tasks.length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                index--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return index;
    }

    public Task getTask(int index) throws IllegalArgumentException {
        if(index < 0 || index > this.index) {
            throw new IllegalArgumentException("Incorrect index");
        }

        return tasks[index];
    }

    public ArrayTaskList incoming(int from, int to) throws IllegalArgumentException {
        if(from >= to || from < 0 || to < 0) {
            throw new IllegalArgumentException("Time must be not negative and from < to");
        }

        ArrayTaskList result = new ArrayTaskList();
        for(int i = 0; i < index; i++) {
            if(tasks[i].isRepeated()) {
                if(tasks[i].nextTimeAfter(from) <= to) {
                    result.add(tasks[i]);
                }
            }
            else {
                if(tasks[i].getTime() >= from && tasks[i].getTime() <= to) {
                    result.add(tasks[i]);
                }
            }
        }
        return result;
    }
}
