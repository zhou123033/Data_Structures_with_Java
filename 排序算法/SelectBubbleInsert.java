import java.util.Arrays;

/**
 * 冒泡排序
 */
public class SelectBubbleInsert {

    /**
     * 插入排序
     * i 代表当前待插入的元素位置, j 代表当前的前一个元素位置
     * j + 1 代表当前待插入的元素, 即 i 的位置
     * [0, i-1] 已排好序区域, [i, arr.length-1] 待排序区域, 每次把 i 位置
     * 的元素插入到已排序区域, 通过不断与 i 前面那个元素比较大小交换位置实现
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    // 冒泡排序改进版
    private static void bubbleSort2(int[] arr) {
        int j = arr.length - 1;
        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                    x = i;
                }
            }
            j = x;
        } while (j != 0);
    }

    // 数组中交换 i 和 j 位置的数
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
