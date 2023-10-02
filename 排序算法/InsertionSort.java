import java.util.Arrays;

/**
 * 插入排序
 * * 将数组分为两部分 [0 .. low-1] [low .. a.length-1]
 *   1. 左边 [0 .. low-1] 是已排序部分
 *   2. 右边 [low .. a.length-1] 是未排序部分
 * * 每次从未排序区域取出 low 位置的元素，插入到已排序区域
 */
public class InsertionSort {
    
    public static void sort(int[] a) {
        for (int low = 1; low < a.length; low++) {
            int t = a[low];
            int i = low - 1;
            // 自右向左找插入位置，如果比待插入元素大，则不断右移，空出插入位置
            while (i >= 0 && t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            // 找到插入位置
            if (i + 1 != low) {
                a[i + 1] = t;
            }
        }
    }

    public static void demoSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 3, 4, 2, 1, 11, 10, 15};
        System.out.println(Arrays.toString(a));
        demoSort(a);
        System.out.println(Arrays.toString(a));
    }
}
