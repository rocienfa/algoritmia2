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
    private static int functionDp(int n, int[] dp) {
        Arrays.fill(dp, -1);

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
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = function(n - 1, dp) + function(n - 2, dp)  + function(n - 3, dp);

        return dp[n];
    }
}
