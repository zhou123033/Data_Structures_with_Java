package 链表;

import java.util.Iterator;

/**
 * 带哨兵节点的双向链表
 */
public class DoublyLinkedListSentinel implements Iterable<Integer>{
    static class Node {

        Node prev; // 上一个节点指针
        Node next; // 下一个节点指针
        int value; // 值

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // 头哨兵
    private Node tail; // 尾哨兵

    public DoublyLinkedListSentinel() {

        head = new Node(null, 1, null);
        tail = new Node(null, 0, null);

        head.next = tail;
        tail.prev = head;
    }

    /** 查找节点的工具方法 */
    private Node findNode(int index) {
        int i = -1;
        for(Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast() {
        Node removed = tail.prev;
        if(removed == head) {
            throw illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void remove(int index) {

        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex(index);
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    private IllegalArgumentException illegalIndex(int index) {
        throw new IllegalArgumentException();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
