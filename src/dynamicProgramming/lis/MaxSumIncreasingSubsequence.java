package dynamicProgramming.lis;

public class MaxSumIncreasingSubsequence {
    public int maxSumIncreasingSubsequence(int[] sequence) {
        int size = sequence.length;

        int[] dp = new int[size];
        int[] maxSum = new int[size];

        int maxOverall = 0;

        for (int i = 0; i < size; i++) {
            dp[i] = sequence[i];
            maxSum[i] = sequence[i]; // Initialize maxSum with current element value

            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + sequence[i]);
                    maxSum[i] = Math.max(maxSum[i], dp[i]);
                }
            }

            maxOverall = Math.max(maxOverall, maxSum[i]);
        }

        return maxOverall;
    }

    public static void main(String[] args) {
        MaxSumIncreasingSubsequence solution = new MaxSumIncreasingSubsequence();

        int[] scenario1 = {1, 100, 3, 2, 6, 8, 9, 1000};
        System.out.println("Max Sum: " + solution.maxSumIncreasingSubsequence(scenario1)); // Resutl: 101
    }
}
