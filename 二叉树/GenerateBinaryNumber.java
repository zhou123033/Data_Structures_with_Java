package 二叉树;

/**
 * 请你实现一个函数，接受一个正整数 n，函数能够打印所有长度为 n 的二进制数。
 * 例如输入 n = 3，算法打印 000 001 010 011 100 101 110 111，共 2^3 = 8 个结果。
 * *
 * 进阶：如果让你打印长度为 n 的所有十进制数，你能够实现吗？
 */
public class GenerateBinaryNumber {
    // 记录遍历过的路径
    static StringBuilder path = new StringBuilder();

    static void generateBinaryNumber(int n) {
        if (n == 0) {
            // 到达叶子节点
            System.out.println(path.toString());
            return;
        }
        for (int i = 0; i < 2; i++) { // 2 代表二进制, 可换成其他整数
            // 前序位置, 进入节点
            path.append(i);
            // 递归子节点
            generateBinaryNumber(n - 1);
            // 后序位置, 离开节点
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateBinaryNumber(3);
    }
}




