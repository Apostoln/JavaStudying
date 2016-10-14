package ua.sumdu.j2se.MykytaBondarenko.tasks;

public class Main {

    public static void main(String[] args) {
        //test:
        TaskList list = new LinkedTaskList();
        //ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("a", 5));
        list.add(new Task("b", 42));
        list.add(new Task("c", 2, 50, 5));

        //list.add(new Task("d", -42)); //IllegalArgumentException here
        //list.add(new Task("e", 50, 2, 5)); //IllegalArgumentException here
        //list.add(new Task("f", 2, 50, 0)); //IllegalArgumentException here
        //list.add(null); //NullPointerException here

        //ArrayTaskList result = list.incoming(6, 43);
        TaskList result = list.incoming(6,43);

        for(int i = 0; i < result.size(); i++) {
            Task temp = result.getTask(i);
            System.out.println(temp.getTitle());
        }

    }
}
