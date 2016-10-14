package ua.sumdu.j2se.MykytaBondarenko.tasks;

import java.util.IllegalFormatCodePointException;

public class LinkedTaskList extends TaskList {
    private static class Node {
        private Task task;
        private Node next;


        public Node(Task task, Node next) {
            this.task = task;
            this.next = next;
        }

        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            next = node;
        }
    }
    Node head = null;

    public void add(Task task) throws NullPointerException {
        if (task == null) {
            throw new NullPointerException("Task is null");
        }
        if (head == null) {
            head = new Node(task, null);
        }
        else {
            head = new Node(task, head);
        }
    };

    public boolean remove(Task task) {
        Node node = head;
        Node previous = null;
        do {
            if (node.getTask().equals(task)) {
                if (previous == null) {
                    head = head.getNext();
                }
                else {
                    previous.setNext(node.getNext());
                }
                return true;
            }
            previous = node;
            node = node.getNext();
        } while (node.getNext() != null);
        return false;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int size = 1;
        for(Node node = head; node.getNext() != null; node = node.getNext(), size++);
        return size;
    }

    public Task getTask(int index) throws IllegalArgumentException {
        if(index > size()) {
            throw new IllegalArgumentException("Time must be not negative and from < to");
        }
        Node node = head;
        for(int i = 0; i != index; i++) {
            node = node.getNext();
        }
        return node.getTask();
    }

    public LinkedTaskList incoming(int from, int to) throws IllegalArgumentException {
        if(from >= to || from < 0 || to < 0) {
            throw new IllegalArgumentException("Time must be not negative and from < to");
        }
        LinkedTaskList result = new LinkedTaskList();

        for(Node node = head; node.getNext() != null; node = node.getNext()) {
            if(node.getTask().isRepeated()) {
                if(node.getTask().nextTimeAfter(from) <= to) {
                    result.add(node.getTask());
                }
            }
            else {
                if(node.getTask().getTime() >= from && node.getTask().getTime() <= to) {
                    result.add(node.getTask());
                }
            }
        }
        return result;
    }
}

