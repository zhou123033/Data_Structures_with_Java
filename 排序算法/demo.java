import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class demo {

    public static void BubbleSort(int[] a) {
        for (int i = 0; i <= a.length - 1; i++) {
            for(int j = 0; j < a.length - 1 - i; j++) {
                print(a);
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    public static void print(int[] a) {
        for (int ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 3, 4, 7, 2, 0, 88, 13, 16};

        BubbleSort(a);

    }
}
