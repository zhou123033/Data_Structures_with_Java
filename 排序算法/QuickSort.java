import edu.princeton.cs.algs4.*;

import java.util.Arrays;

/**
 * 快速排序 - 双边快排
 * 1. 选择最左侧元素作为基准点 pivot
 * 2. j 找比基准点小的, i 找比基准点大的, 一旦找到, 二者进行交换
 *      i 从左向右
 *      j 从右向左
 * 3. 最后基准点与 i 交换, i 即为基准点最终索引
 */
public class QuickSort {

    public static void sort(int[] nums) {
        // 为了避免出现耗时的极端情况，先随机打乱
        StdRandom.shuffle(nums);
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);   // 切分, 找到 pivot
        sort(nums, lo, p - 1);          // 将左半部分nums[lo..p-1]排序
        sort(nums, p + 1, hi);          // 将右半部分nums[p+1..hi]排序
    }

    /**
     * 对 nums[lo..hi] 进行切分
     * 注意事项:
     * 1. 为什么要加内层循环的 i < j 条件
     * 2. 为啥要先处理 j, 再处理 i
     * 3. 随机元素作为基准点, 或随机打乱输入数组
     * */
    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo, j = hi;
        // 当 i == j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i < j) {
            // 1. j 从右向左找小的
            while (i < j && nums[j] > pivot) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }
            // 2. i 从左向右找大的
            while (i < j && nums[i] <= pivot) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot
            // 3. 交换 nums[j] 和 nums[i]
            swap(nums, i, j);
            // 此时 [lo, i] <= pivot && [j, hi] > pivot
        }
        // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        // 此时 i 和 j 相等且都指向小于等于 nums[lo] 的元素, 交换 i 和 lo
        swap(nums, lo, i);
        return i;
    }

    /** 原地交换数组中的两个元素 */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 9, 11, 4};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
