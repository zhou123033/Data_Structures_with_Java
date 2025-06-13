package 链表;

import java.util.Iterator;

/**
 * 环形双向链表
 */
public class DoublyLinkedListSentinel2 implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            Node p = sentinel.next; // 遍历的起点是第一个节点

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {

        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyLinkedListSentinel2() { //链表初始化
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加到第一个
     * @param value-待添加值
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到最后一个
     * @param value-待添加值
     */
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除第一个
     */
    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.next;

        a.next = b;
        b.prev = a;
    }

    /**
     * 删除最后一个
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值删除
     * @param value-目标值
     */
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if(removed == null) {
            return; // 不用删
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值查找节点
     * @param value-目标值
     * @return 返回包含目标值的节点
     */
    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if(p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
