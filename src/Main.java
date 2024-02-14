import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
               result[n] = fibonacci(n-1) + fibonacci(n-2);
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

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] memoization = new int[n + 1];
        initializeArray();
        System.out.printf("Fibonacci(%d) = %d\n", n, fibonacci(n));
//        var result = fibonacciDp(n, memoization);
        System.out.printf("Fibonacci(%d) = %d\n", n,  fibonacciDp(n, memoization));
    }
}