import java.lang.reflect.Array;
import java.util.Arrays;

public class E06Fibonacci {

    public static int fibonacci(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n, cache);
    }

    public static int f(int n, int[] cache) {

        if(cache[n] != -1) {
            return cache[n];
        }

        int x = f(n - 1, cache);
        int y = f(n - 2, cache);
        return x + y;
    }
}
