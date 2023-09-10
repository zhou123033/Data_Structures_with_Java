public class Demo {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        int target = 2;
        search(arr, target);
    }

    private static int search(int[] arr, int targetVal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetVal) {
                return i;
            }
        }
        return -1;
    }

    public static int search(int[] arr, int i, int targetVal) {
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == targetVal) {
            return i;
        }

        return search(arr, i + 1, targetVal);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // 定义：打印 arr[i] 以及之后的所有元素
    private static void printArr(int[] arr, int i) {
        // base case
        if (i == arr.length) {
            return;
        }
        // 打印 arr[i]
        System.out.println(arr[i]);
        // 打印 arr[i+1] 以及以后的所有元素
        printArr(arr, i + 1);
    }

}
