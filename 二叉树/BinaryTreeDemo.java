public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode node = new TreeNode(1);
    }
}

class BinaryTree {

    public TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     * @param node - 节点
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t"); // 值
        preOrder(node.left); // 左
        preOrder(node.right); // 右
    }

    /**
     * 中序遍历
     * @param node - 节点
     */
    public void infixOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        infixOrder(node.left);
        System.out.print(node.val + "\t");
        infixOrder(node.right);
    }

    /**
     * 后序遍历
     * @param node - 节点
     */
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left); // 左
        postOrder(node.right); // 右
        System.out.print(node.val + "\t"); // 值
    }
}

class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}