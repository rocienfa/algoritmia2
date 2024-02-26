package dynamicProgramming.knapsack;

public class Knapsack {
    private static int[][] dp;

    private static int knapsackMaxValue(int[] weights, int[] values, int W) {
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

    private static void displaySelectedItems(int[] weights, int[] values, int W) {
        int n = values.length;
        int totalWeight = W;

        while (n != 0) {
            // dp[4][4] != dp[3][4]
            if (dp[n][totalWeight] != dp[n - 1][totalWeight]) {
                System.out.println("\tItem " + n + " with weight = " + weights[n - 1] + " and value = " + values[n - 1]);

                totalWeight = totalWeight - weights[n-1];
                System.out.println(totalWeight);
            }

            n--; // n = 4
        }
    }

    private static int getMaxValueInContainer(int[] weights, int[] values, int maxCapacity) {
        int n = values.length;

        for (int itemNumber = 1; itemNumber <= n; itemNumber++) {
            for (int capacity = 1; capacity <= maxCapacity; capacity++) {
                //itemNumber = 1
                //weights[0] <= 1  => 4 <= 1
                if (weights[itemNumber - 1] <= capacity) {
                    // values[0] + dp[0][1 - weights[0]] => 5 + dp[0][4] = 5
                    // dp[0][1] => 0
                    // then max(5,0) = 5
                    dp[itemNumber][capacity] = Math.max(
                            values[itemNumber - 1] + dp[itemNumber - 1][capacity - weights[itemNumber - 1]],
                            dp[itemNumber - 1][capacity]);
                } else {
                    // dp[1][1] = dp[0][1] => dp[1][1] = 0
                    dp[itemNumber][capacity] = dp[itemNumber - 1][capacity];
                }

                System.out.print(dp[itemNumber][capacity] + " ");
            }

            System.out.print("\n");
        }

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

        var maxValue =  getMaxValueInContainer(weights, values, W);
//        var maxValue = knapsackMaxValue(weights, values, W);
        System.out.printf("Max value: %d \n", maxValue);
        System.out.println("Selected Items: ");
        displaySelectedItems(weights, values, W);
    }
}
