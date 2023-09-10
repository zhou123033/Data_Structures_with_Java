public class E05InsertionSort {
    public static void sort(int[] a) {

    }

    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }

        int t = a[low];
        int i = low - 1; // 已排序区域指针

        insertion(a, low + 1);
    }

}
