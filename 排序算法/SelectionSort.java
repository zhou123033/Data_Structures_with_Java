import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] a) {
        // 1. 选择轮数 a.length - 1
        // 2. 交换的索引位置(right) 初始 a.length - 1，每次递减
        for (int right = a.length - 1; right > 0; right--) {
            int max = right;
            for (int i = 0; i <right; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            // exchange element
            swap(a, max, right);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void demoSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 7, 4, 9};
        System.out.println(Arrays.toString(a));
        demoSort(a);
        System.out.println(Arrays.toString(a));
    }
}