/**
 * 二叉搜索树 泛型key版本
 */
public class BSTTree2<K extends Comparable<K>, V> {

    static class BSTNode<K, V> {
        K key;
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode<K, V> root;

    public V get(K key) {
        BSTNode<K, V> p = root;
        while (p != null) {
            // 比较 key 和 p.key
            /*
            compareTo 返回值:
                -1 -> key < p.key
                0 -> key == p.key
                1 -> key > p.key
             */
            int result = key.compareTo(p.key);
            if (result < 0) {
                p = p.left;
            } else if (result > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }
}
