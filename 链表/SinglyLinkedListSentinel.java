import java.util.Iterator;

/**
 * 带哨兵节点的单向链表
 */
public class SinglyLinkedListSentinel implements Iterable<Integer>{
    private Node head = new Node(1, null); //头指针

    /** 节点类 */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null; // 没找到
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    /** 链表头部添加 */
    public void addFirst(int value) {
        insert(0, value);
    }

    private Node findLast() {
        Node p;
        for(p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    /**
     * 向索引位置插入
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) { //找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        Node prev = findNode(index - 1); // 上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next; // 被删除的节点
        prev.next = removed.next;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    /**
     * 链表尾部添加
     * @param value - 待添加值
     */
    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    /** 遍历链表 */
    public void loop1() {
        Node p = head.next;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    public void loop2() {
        for(Node p = head.next; p != null; p = p.next) {
            System.out.println(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值，并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }
}
