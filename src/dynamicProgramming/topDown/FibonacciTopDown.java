package dynamicProgramming.topDown;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTopDown {
    static final int SIZE = 100;
    static int[] result = new int[SIZE];
    public static void initializeArray() {
        Arrays.fill(result, -1);
    }

    public static int fibonacciDp2(int n) {// n=4; memoization = [0,0,0,0,0]
        // n = 3; memoization = [0,0,0,0,0]
        if (result[n] == -1) {
            if (n<=1)
                result[n] = n;
            else
                result[n] = fibonacciDp2(n-1) + fibonacciDp2(n-2);
        }

        return result[n];
    }

    public static int fibonacciDp(int n, int[] memoization) {// n=4; memoization = [0,0,0,0,0]
        // n = 3; memoization = [0,0,0,0,0]
        if (n <= 1)
            return n;

        if (memoization[n] != 0)
            return memoization[n];
        memoization[n] = fibonacciDp(n-1, memoization) + fibonacciDp(n-2, memoization);

        return memoization[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] memoization = new int[n + 1];
        initializeArray();
//        var result = fibonacciDp(n, memoization);
        System.out.printf("Fibonacci(%d) = %d\n", n,  fibonacciDp(n, memoization));
    }
}
