package BinarySearch;

public class BinarySearch {

    /**
     * 寻找一个数 (基本的二分查找)
     * @param nums 输入数组，已经排好序
     * @param target 要查找的目标数
     * @return 要查找的数所在的索引位置, 如果没找到, 返回 -1
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 有序数组中找>=num的最左位置
     * 保证arr有序, 才能用这个方法, 没找到就返回 -1
     */
    public static int findLeft(int[] arr, int num) {
        int left = 0, right = arr.length - 1, mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 有序数组中查找<=num的最右位置, 没找到就返回 -1
     */
    public static int findRight(int[] arr, int num) {
        int left = 0, right = arr.length - 1, mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] > num) {
                right = mid - 1;
            }
        }
        return ans;
    }
}
