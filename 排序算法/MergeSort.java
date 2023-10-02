import java.util.Arrays;

@SuppressWarnings("all")

public class MergeSort {

    private static int[] aux;  // 归并所需的辅助数组

    public static void sort(int[] a) {
        aux = new int[a.length];  // 一次性分配空间
        sort(a, 0, a.length - 1);
    }

    // 自顶向下的归并排序
    public static void sort(int[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid); // 将左半边排序
        sort(a, mid+1, hi); // 将右半边排序
        merge(a, lo, mid, hi); // 归并结果
    }

    // 原地归并的抽象方法
    public static void merge(int[] a, int lo, int mid, int hi) {

        // 将 a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo;
        int j = mid+1;

        for (int k = lo; k <= hi; k++) { // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) { // 归并回到a[lo..hi]
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class MergeBU {
    public static int[] aux;

    public static void sort(int[] a) {
        int N = a.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz) { // sz子数组大小
            for (int lo = 0; lo < N-sz; lo += sz+sz) { // lo:子数组索引
                MergeSort.merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}
