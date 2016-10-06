package ua.sumdu.j2se.MykytaBondarenko.tasks;

public class ArrayTaskList {
    private final int BASIC_SIZE = 5;
    private Task[] tasks = new Task[BASIC_SIZE];
    int index = 0;

    public void add(Task task) {
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
        return index + 1;
    }

    public Task getTask(int index) {
        return tasks[index];
    }
}
