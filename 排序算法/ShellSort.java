/**
 * 1. 希尔排序 就是分组实现插入，每组元素间隙称为 gap
 * 2. 每轮排序后 gap 逐渐变小，直至 gap 为 1 完成排序
 * 3. 对插入排序的优化，让元素更快速地交换到最终位置
 */
public class ShellSort {
    public static void sort(int[] a) {
        // a.length / 2  /2  1
        for (int gap = a.length / 2; gap >= 1; gap = gap / 2) {
            for (int low = gap; low < a.length; low++) {
                int t = a[low];
                int i = low - gap;
                // 自右向左找插入位置，如果比待插入元素大，则不断右移，空出插入位置
                while (i >= 0 && t < a[i]) {
                    a[i + gap] = a[i];
                    i -= gap;
                }
                // 找到插入位置
                if (i != low - gap) {
                    a[i + gap] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};

    }
}
