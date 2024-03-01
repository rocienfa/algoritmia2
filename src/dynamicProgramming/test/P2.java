package dynamicProgramming.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {
    // a. Identify the problem in general terms.
    // Needs to order a sequence, that contains a value N positive integer

    // b. Analyse the problem based on sub-problems and find the formula.
    // Sequence: a1, a2, …, an where n is the length of sequence
    // dp[i] to represent the length of the longest increasing subsequence (LIS) and i is the index of the latest element on the dp array
    // Formula:
    // dp[i] = Max{dp[j] + 1 | array[j] < array[i]} where j=0 and i=1

    // c. Identify where the overlap of sub-problems occurs.
    // The overlap of sub-problems occurs when computing the value of dp[i] for a certain index i
    // To calculate dp[i] it is needed to consider all previous indices where j < i and compare
    // the elements at those indices with array[i]. If array[j] < array[i]

    // d. Implement the solution to the problem using DP bottom-up.
    public static List<Integer> LIS(int[] sequence, int size) {
        int[] lis = new int[size];
        Arrays.fill(lis, 1);

        List<Integer> pathLIS = new ArrayList<>();

        // Applying LIS
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    System.out.println(lis[i]);
                }
            }
        }

        int  lengthOfLIS = 0;
        for (int l : lis) {
            lengthOfLIS = Math.max(lengthOfLIS, l);
        }

        // Getting the path of LIS
        int i = size - 1;
        int j = lengthOfLIS;
        while (i >= 0 && j >= 0) {
            if (lis[i] == j) {
                pathLIS.add(sequence[i]);
                j--;
            }

            i--;
        }

        return pathLIS;
        // [1 12 5 31]
        // LIS PATH [1,5,31]
        // LIS PATH [1,12,31]

        // [1,5,12,31] -> 1
    }

    public static int LIS(int[] sequence) {
        int n = sequence.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int length : lis) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static int getNumberOfMovements(int[] sequence) {
        int size = sequence.length;
        int lisResult = LIS(sequence);

        // Number of movements needed = length of sequence - length of LIS
        return size - lisResult;
    }

    public static void main(String[] args) {
        int[] sequence1 = {1,2,3,4,5}; // 3
        var sequence1Size = sequence1.length;
        int[] sequence2 = {30, 21, 15, 12, 4};
        var sequence2Size = sequence2.length;

        // opt 1
        List<Integer> pathLIS = LIS(sequence1, sequence1Size);
        List<Integer> pathLIS2 = LIS(sequence2, sequence2Size);

        System.out.println("**************************OPT1**************************");
        System.out.println("Number of movements: " + (sequence1.length - pathLIS.size()));
        System.out.println("Number of movements: " + (sequence2.length - pathLIS2.size()));
        System.out.println("********************************************************");

        //opt 2
        System.out.println("**************************OPT2**************************");
//        System.out.println("Number of movements: " + getNumberOfMovements(sequence1));
//        System.out.println("Number of movements: " + getNumberOfMovements(sequence2));
        System.out.println("********************************************************");
    }
}
//