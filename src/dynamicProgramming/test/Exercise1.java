package dynamicProgramming.test;

import java.util.Arrays;

public class Exercise1 {
    private static int function(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        // the overlap occurs here
        dp[n] = function(n - 1, dp) + function(n - 2, dp)  + function(n - 3, dp);

        return dp[n];
    }

    //a. Update the code so it uses dynamic programming
    private static int functionDpTopDown(int n, int[] dp) {
//        Arrays.fill(dp, -1);

        /* Start Base cases
        b. Do we still need the base case after converting the code to dynamic programming? why?
        No, after converting the code to dp and using memoization, we do not need this base case if (n == 0)
        since it will be managed by the initialization of the memoization array
        */

        // This case base is not needed when applying dp
        if (n == 0) {
            return 0;
        }

        // This case base is still needed to stop recursion
        if (n == 1 || n == 2) {
            return 1;
        }
        /* End Base cases */

        // Check if the calculation/operation was already processed, if yes, get the result
        // applies memoization because is a top-down recursive way
        //if (dp[n] != -1) {
        //    return dp[n];
        //}

        if (dp[n] == 0)
            dp[n] = functionDpTopDown(n-1, dp) + functionDpTopDown(n-2, dp)  + functionDpTopDown(n-3, dp);

        return dp[n];
    }

    public static int functionBottomUp(int n,  int[] dp) {
//        if (n == 0) {
//            return 0;
//        }
//
//        // This case base is still needed to stop recursion
//        if (n == 1 || n == 2) {
//            return 1;
//        }

        // It could be possible to resume case bases using bottom-up approach:
        // when n = 0 => dp[0] = 0; dp[1] = 1; dp[2] = 1
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] dp = new int[n];

        int resultDpTopDown = functionDpTopDown(n - 1, dp);
        int resultDpBottomUp = functionBottomUp(n - 1, dp);

        System.out.println("DP top-down result:" + resultDpTopDown);
        System.out.println("DP bottom-up result:" + resultDpBottomUp);
    }
}
