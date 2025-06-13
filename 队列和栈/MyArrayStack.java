package 队列和栈;

import java.util.NoSuchElementException;

public class MyArrayStack<E> {

    private 数组链表.MyArrayList<E> arr = new 数组链表.MyArrayList<>();

    public void push(E e) {
        arr.addLast(e);
    }

    public E pop() {
        return arr.removeLast();
    }

    public E peek() {
        if (arr.isEmpty()) {
            throw new NoSuchElementException();
        }
        return arr.get(arr.size() - 1);
    }
}
