import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Search Tree 二叉搜索树
 */
public class BSTree {

    BSTNode root; // 根节点

    public static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 查找关键字对应的值
     * @param key - 关键字
     * @return 关键字对应的值
     */
    public Object get(int key) { // 非递归的 get 方法
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public Object getRecursive(int key) { // 递归 get 方法
        return doGet(root, key);
    }

    private Object doGet(BSTNode node, int key) { // get方法的递归版本
        if (node == null) {
            return null; // 没找到
        }
        if (key < node.key) {
            return doGet(node.left, key); // 向左找
        } else if (key > node.key) {
            return doGet(node.right, key); // 向右找
        } else {
            return node.value; // 找到了
        }
    }

    /**
     * 查找最小关键字对应的值
     * @return 关键字对应的值
     */
    public Object min() {
       return min(root);
    }

    // 查找任意一个节点作为起点的子树中最小值
    public Object min(BSTNode node) { // 非递归的 min 方法
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    public Object minRecursive() {
        return doMin(root);
    }

    public Object doMin(BSTNode node) { // 递归 min 方法
        if (node == null) {
            return null;
        }
        if (node.left == null) { // 最小的节点
            return node.value;
        }
        return doMin(node.left);
    }

    /**
     * 查找最大关键字对应值
     * @return 关键字对应的值
     */
    public Object max() {
        return max(root);
    }

    // 查找任意一个节点作为起点的子树中最大值
    public Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    /**
     * 存储关键字和对应值
     * @param key - 关键字
     * @param value - 对应值
     */
    public void put(int key, Object value) { // 非递归
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                // 1. key 已有 -> 更新
                node.value = value;
                return;
            }
        }
        // parent 父节点
        if (parent == null) { // 树为空，添加新节点作为根节点
            root = new BSTNode(key, value);
            return;
        }
        // 2. key 没有 -> 新增
        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }

    /**
     * 查找关键字的后继值
     * @param key - 关键字
     * @return 后继值
     */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                break;
            }
        }
        // 没找到节点
        if (p == null) {
            return null;
        }
        // 找到节点 -> 情况1: 节点有右子树，此时后任就是右子树的最小值
        if (p.right != null) {
            return min(p.right);
        }
        // 找到节点 -> 情况2: 节点没有右子树，若离它最近的、自右而来的祖先就是后任
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    /**
     * 查找 key 关键字的前驱节点的值
     * @param key - 关键字
     * @return 前驱值
     */
    public Object predecessor(int key) {
        /*
            情况1: 节点有左子树，此时前任节点就是左子树的最大值
            情况2: 节点没有左子树，若离它最近的、自左而来的祖先就是前任
         */
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }
        // 没找到节点
        if (p == null) {
            return null;
        }
        // 找到节点 -> 情况1: 节点有左子树，此时前任就是左子树的最大值
        if (p.left != null) {
            return max(p.left);
        }
        // 找到节点 -> 情况2: 节点没有左子树，若离它最近的、自左而来的祖先就是前任
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    /**
     * 根据 key 关键字删除
     * @param key - 关键字
     * @return 被删除关键字对应值
     *
     * 情况1. 被删除节点没有左孩子，将右孩子托孤给Parent
     * 情况2. 被删除节点没有右孩子，将左孩子托孤给Parent
     * 情况3. 被删除节点左右孩子都没有，已经被涵盖在情况1和情况2当中，把 null 托孤给 parent
     * 情况4. 被删除节点左右孩子都有，可以将它的后继节点(称为S)托孤给 Parent，再称S的父亲为
     *       SP，又分两种情况:
     *       1. SP 就是被删除节点，此时 D 与 S 紧邻，只需要将 S 托孤给 Parent
     *       2. SP 不是被删除节点，此时 D 与 S 不相邻，此时需要将 S 的后代托孤给 SP，再将
     *          S 托孤给 Parent
     */
    public Object delete(int key) {
        BSTNode p = root; // 被删除节点 p
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (key > p.key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        // 删除操作
        if (p.left == null) {
            // 情况1
            shift(parent, p, p.right);
        } else if (p.right == null) {
            // 情况2
            shift(parent, p, p.left);
        } else {
            // 情况4
            //4.1 被删除节点找后继
            BSTNode s = p.right;
            BSTNode sParent = p; // 后继节点的父节点
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // 循环结束，找到后继节点即为 s
            if (sParent != p) { // s 与被删除节点 p 不相邻
                // 4.2 如果被删除节点和后继节点不相邻，则处理后继节点的孩子
                shift(sParent, s, s.right); // 不可能有左孩子节点
                s.right = p.right;
            }
            //4.3 后继节点取代被删除节点
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    /**
     * 托孤方法
     * @param parent - 被删除节点的父节点
     * @param deleted - 被删除节点
     * @param child - 被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) { // 被删除节点是 parent 的左节点
            parent.left = child;
        } else { // 被删除节点是 parent 的右节点
            parent.right = child;
        }
    }

    /**
     * delete 方法的递归实现
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object deleteRecursive(int key) {
        ArrayList<Object> result = new ArrayList<>(); // 保存被删除节点的值
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * 递归 delete 方法
     * @param node 递归删除的起点节点
     * @param key 关键字
     * @return 把 待删除节点 删除后剩下的子节点 或 null
     */
    private BSTNode doDelete(BSTNode node, int key, ArrayList<Object> result) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = doDelete(node.left, key, result);
            return node;
        } else if (key > node.key) {
            node.right = doDelete(node.right, key, result);
            return node;
        }
        result.add(node.value);
        // 情况1 - 只有右孩子
        if (node.left == null) {
            return node.right;
        }
        // 情况2 - 只有左孩子
        if (node.right == null) {
            return node.left;
        }
        // 情况3 - 有两个孩子 (找被删除节点的后继节点)
        BSTNode s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        s.right = doDelete(node.right, s.key, new ArrayList<>());
        s.left = node.left;
        return s;
    }

    /* 范围查询 */
    // 中序遍历

    // 找 小于 key 的所有 value
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>(); // 栈记录所经过的节点
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找 大于 key 的所有value
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key > key) {
                    result.add(pop.value);
                }
                p = pop.right;
            }
        }
        return result;
    }

    // 找 >= key1 且 <= key2 的所有值
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                // 处理值
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }
}
