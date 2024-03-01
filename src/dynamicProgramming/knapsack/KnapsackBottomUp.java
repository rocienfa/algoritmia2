package dynamicProgramming.knapsack;

import java.util.ArrayList;
import java.util.List;

public class KnapsackBottomUp {
    private static int[][] dp;

    private static int knapsackMaxValue2(int[] weights, int[] values, int W) {
        int n = values.length;

        // display the table filled
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];

                if ((j >= weights[i-1]) && (dp[i][j] < dp[i - 1][j - weights[i - 1]] + values[i - 1])) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }

                System.out.print(dp[i][j] + " ");
            }

            System.out.print("\n");
        }

        return dp[n][W];
    }

    private static int knapsackMaxValue(int[] weights, int[] values, int maxCapacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][maxCapacity + 1];

        // display the table filled
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

//                System.out.print(dp[i][j] + " ");
            }
//            System.out.print("\n");
        }

        int maxValue = dp[n][maxCapacity];
        int remainingCapacity = maxCapacity;
        List<Integer> itemsIncluded = new ArrayList<>();

        for (int i = n; i > 0 && maxValue > 0; i--) {
            System.out.println(maxValue + " != " + dp[i - 1][remainingCapacity]);
            if (maxValue != dp[i - 1][remainingCapacity]) {
                itemsIncluded.add(i);
                maxValue -= values[i - 1];
                remainingCapacity -= weights[i - 1];
            }
        }

        System.out.println("Items to be included: " + itemsIncluded);

        return dp[n][maxCapacity];
    }

    public static void main(String[] args) {
        // int[] weights = new int[]{3, 4, 5, 9, 4};
        int[] weights = new int[]{4, 3, 2, 1, 3};

        // int[] values = new int[]{3, 4, 4, 10, 4};
        int[] values = new int[]{5, 2, 3, 2, 4};

        // total weight
        int W = 7;
        int n = values.length;

        dp = new int[n + 1][W + 1];

        var maxValue =  knapsackMaxValue(weights, values, W);
//        var maxValue = knapsackMaxValue(weights, values, W);
        System.out.printf("Max value: %d \n", maxValue);
    }
}
