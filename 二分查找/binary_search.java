public class binary_search {
    public static int binarySearch(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (a[m] < target) {
                i = m + 1;
            } else if (a[m] > target) {
                j = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
