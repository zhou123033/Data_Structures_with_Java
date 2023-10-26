import java.util.LinkedList;

public class Demo {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    LinkedList<Integer> preorder = new LinkedList<>();
    LinkedList<Integer> inorder = new LinkedList<>();
    LinkedList<Integer> postorder = new LinkedList<>();

    // 二叉树递归遍历框架
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        preorder.add(root.val);

        traverse(root.left);

        // 中序遍历位置
        inorder.add(root.val);

        traverse(root.right);

        // 后序遍历位置
        postorder.add(root.val);
    }
}
