package dynamicProgramming.levenshteinDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GLevenshteinDistance {
    public static int levenshteinDistance(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a matrix to store the distances
        int[][] dp = new int[m + 1][n + 1];

        // Fil matrix
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
            if (i <= n)
                dp[0][i] = i;
        }

        // Fill matrix using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int substitutionCost = Math.abs(text1.charAt(i - 1) - text2.charAt(j - 1));
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + text1.charAt(i - 1),
                                    dp[i][j - 1] + text2.charAt(j - 1)),
                            dp[i - 1][j - 1] + substitutionCost);

//                    dp[i][j] = Math.min(dp[i - 1][j] + text1.charAt(i - 1),
//                            Math.min(dp[i][j - 1] + text2.charAt(j - 1),
//                                    dp[i - 1][j - 1] + substitutionCost));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter first string:");
        String text1 = br.readLine();

        System.out.println("Enter second string:");
        String text2 = br.readLine();

        int distance = levenshteinDistance(text1.strip(), text2.strip());
        System.out.println("Levenshtein distance between and costs based on index \"" + text1 + "\" and \"" + text2 + "\" is: " + distance);
    }
}
