package dynamicProgramming.knapsack;

import java.util.Arrays;

public class KnapsackTopDown {
    // defining memoization table to store previously result of sub-problems
    static int[][] memoization;

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        memoization = new int[n + 1][capacity + 1];

        for (int[] row : memoization) {
            Arrays.fill(row, -1);
        }

        return knapsackRecursive(weights, values, capacity, n);
    }

    public static int knapsackRecursive(int[] weights, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (memoization[n][capacity] != -1) {
            return memoization[n][capacity];
        }

        if (weights[n - 1] > capacity) {
            memoization[n][capacity] = knapsackRecursive(weights, values, capacity, n - 1);
        } else {
            memoization[n][capacity] = Math.max(values[n - 1] + knapsackRecursive(weights, values, capacity - weights[n - 1], n - 1),
                    knapsackRecursive(weights, values, capacity, n - 1));
        }

        return memoization[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {4, 3, 2, 1, 3};
        int[] values = {5, 2, 3, 2, 4};
        int capacity = 7;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value: " + maxValue);
    }
}
