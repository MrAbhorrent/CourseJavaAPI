package Seminar04;

import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Object> list;


    public MyQueue() {
        this.list = new LinkedList<>();
    }

    public MyQueue(LinkedList<Object> linkedList) {
        this.list = new LinkedList<>(linkedList);
    }

    public void enqueue(Object element) {
        list.addLast(element);
    }

    public Object dequeue() {
        return list.pollFirst();
    }

    public Object first() {
        return list.peekFirst();
    }

    @Override
    public String toString() {
        int size = list.size();
        StringBuilder result = new StringBuilder("[");
        if (!list.isEmpty()) {
            for (int i = 0; i < size; i++) {
                result.append(String.format(" %s", list.get(i).toString()));
                if (i < size - 1) {
                    result.append(",");
                }
            }
        }
        return result
                .append("]")
                .toString();
    }
}
