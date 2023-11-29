/**
 * BST - CS61B 23fall
 * Binary Search Tree
 */
public class BST<Key> {
    private Key key;
    private BSTree left;
    private BSTree right;

    public BST(Key key, BSTree left, BSTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public BST(Key key) {
        this.key = key;
    }

    public static BST find(BST T, Key sk) {
        if (T == null) {
            return null;
        }
        if (sk.equals(T.key)) {
            return T;
        } else if (sk < T.key) {
            return find(T.left, sk);
        } else {
            return find(T.right, sk);
        }
    }

    public static BST insert(BST T, Key ik) {
        if (T == null) {
            return new BST(ik);
        }
        if (ik < T.key) {
            T.left = insert(T.left, ik);
        } else if (ik > T.key) {
            T.right = insert(T.right, ik);
        }
        return T;
    }
}