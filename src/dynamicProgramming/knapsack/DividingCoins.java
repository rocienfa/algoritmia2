package dynamicProgramming.knapsack;

import java.util.Scanner;

//
// dp[i][diff] = min(dp[i-1][diff - coins[i-1]], dp[i-1][diff + coins[i-1]])
// DiffMin() = min (, )
public class DividingCoins {
    public static int fairDivision(int[] coins) {
        int total = 0;

        for (int coin : coins) {
            total += coin;
        }

        int halfTotal = total / 2;
        int n = coins.length;
        boolean[][] dp = new boolean[n + 1][halfTotal + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= halfTotal; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - coins[i - 1]];
                }
            }
        }

        int difference = Integer.MAX_VALUE;
        for (int j = halfTotal; j >= 0; j--) {
            if (dp[n][j]) {
                difference = total - 2 * j;
                break;
            }
        }

        return difference;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] results = new int[n];

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[] coins = new int[m];
            for (int j = 0; j < m; j++) {
                coins[j] = scanner.nextInt();
            }
            results[i] = fairDivision(coins);
        }

        for (int res : results) {
            System.out.println(res);
        }
    }
}
