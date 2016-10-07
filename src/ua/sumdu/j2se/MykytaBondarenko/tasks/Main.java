package ua.sumdu.j2se.MykytaBondarenko.tasks;

public class Main {

    public static void main(String[] args) {
        //test:
        ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("a", 5));
        list.add(new Task("b", 42));
        list.add(new Task("c", 2, 50, 5));
        ArrayTaskList result = list.incoming(6, 43);
        for(int i = 0; i < result.size(); i++) {
            Task temp = result.getTask(i);
            System.out.println(temp.getTitle());
        }
    }
}
