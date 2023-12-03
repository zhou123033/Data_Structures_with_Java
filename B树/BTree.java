import java.util.Arrays;

public class BTree {

    static class Node {
        int[] keys; // 存放关键字的数组
        Node[] children; // 孩子
        int keyNumber; // 有效关键字数目
        boolean leaf = true; // 判断节点是否是叶子节点
        int t; // 最小度数(最少孩子数)

        public Node(int t) { // t >= 2
            this.t = t;
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        // 多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // 执行到此时 keys[i] > key 或 i == keyNumber
            if (leaf) {
                return null;
            }
            // 非叶子情况
            return children[i].get(key);
        }

        // 向 keys 数组的指定索引处插入 key
        void insertKey(int key, int index) {
            // 从 index 处往后移动元素，拷贝元素
            System.arraycopy(keys, index, keys, index + 1,
                    keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        // 向 children 指定索引处插入 child
        void insertChild(Node child, int index) {
            // 从 index 处向后移动元素
            System.arraycopy(children, index, children, index + 1,
                    keyNumber - index);
            children[index] = child;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }
    }

    Node root;

    int t; // 树中节点最小度数
    final int MIN_KEY_NUMBER; // 最小key数目
    final int MAX_KEY_NUMBER; // 最大key数目

    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;
    }

    // 1. 是否存在 方法
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    // 2. 新增 方法
    /**
     * 首先查找本节点中的插入位置 i, 如果没有空位(key 被找到), 应该
     * 走更新的逻辑. 接下来分两种情况：
     * 如果节点是叶子节点，可以直接插入了
     * 如果节点是非叶子节点，需要继续在 children[i] 处继续递归插入
     * 无论哪种情况，插入完成后都可能超过节点 keys 数目限制，此时应当
     * 执行节点分裂
     */
    public void put(int key) {
        doPut(root, key);
    }
    private void doPut(Node node, int key) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return; // 更新, 这里key没有value, 所以直接return
            }
            if (node.keys[i] > key) {
                break; //找到了插入位置，即为此时的 i
            }
            i++;
        }
        if (node.leaf) {
            node.insertKey(key, i);
        } else {
            doPut(node.children[i], key);
        }
    }

    // 3. 删除 方法
}
