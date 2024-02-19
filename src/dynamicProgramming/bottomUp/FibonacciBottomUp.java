package dynamicProgramming.bottomUp;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class FibonacciBottomUp {

    public static int fibonacciTabulation(int n) {
        int[] tabulation = new int[n+1];
        // index=0 = 0; index=1=1
        tabulation[0] = 0;
        tabulation[1] = 1;

        for (int i = 2; i <= n; i++) {
            tabulation[i] = tabulation[i -1] + tabulation[i-2];
        }

        return tabulation[n];
    }
    // fib(11)
    // array {0,1,2,3,4,5,6,7,8,9,10,11}
    // array {0,1,nul, ... null}
    // array[11] = out of range
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;

        int prev = 0;
        int current = 1;

        // iterative vs recursive
        for (int i = 2; i <= n; i++) {
            int temporal = current;
            current += prev;
            prev = temporal;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("Fibonacci(%d) = %d\n", n, fibonacciTabulation(n));
    }
}
