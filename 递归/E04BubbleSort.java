import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 递归冒泡排序
 * -
 * 将数组划分为两部分 [0 ... j] [j+1 ... a.length-1]
 * 左边 [0 ... j] 是未排序部分
 * 右边 [j+1 ... a.length-1] 是已排序部分
 * 未排序区间内，相邻的两个元素比较，如果前一个大于后一个，则交换位置
 */
public class E04BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    // j 代表未排序区域的右边界
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if(a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }
        bubble(a, x);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
