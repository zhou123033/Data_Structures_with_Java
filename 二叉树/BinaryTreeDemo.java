package 二叉树;

import java.util.LinkedList;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        /* 迭代遍历二叉树的模板 */
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                // 待处理左子树
                System.out.println("前: " + curr.val);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    System.out.println("中: " + peek.val);
                    pop = stack.pop();
                    System.out.println("后: " + pop.val);
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("后: " + pop.val);
                }
                // 待处理右子树
                else {
                    System.out.println("中: " + peek.val);
                    curr = peek.right;
                }
            }
        }
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
    static void preOrder(TreeNode node) {
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
    static void infixOrder(TreeNode node) {
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
    static void postOrder(TreeNode node) {
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

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}