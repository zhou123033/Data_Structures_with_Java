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
}