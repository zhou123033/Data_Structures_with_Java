public class E03BinarySearch {

    public static int search(int[] a, int target) {

        return -1;
    }

    /**
     * 递归（子问题）函数
     * @param a - 数组
     * @param target - 待查找值
     * @param i - 起始索引（包含）
     * @param j - 结束索引（包含）
     * @return - 找到返回索引
     *           找不到返回-1
     */
    private static int f(int[] a, int target, int i, int j) {
        if(i > j) {
            return -1;
        }
        int m = (i + j) / 2;
        if (target < a[m]) {
            return f(a, target, i, m - 1);
        } else if (target > a[m]) {
            return f(a, target, m + 1, j);
        } else {
            return m;
        }
    }
}
