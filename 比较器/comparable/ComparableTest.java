package comparable;

import org.junit.Test;

import java.util.Arrays;

public class ComparableTest {
    @Test
    public void test1() {
        String[] arr = new String[]{"Tom", "Jerry", "Tony", "Rose", "Jack", "Lucy"};

        Arrays.sort(arr);

        // 排序后，遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
