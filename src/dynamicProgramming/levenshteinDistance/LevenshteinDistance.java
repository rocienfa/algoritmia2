package dynamicProgramming.levenshteinDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LevenshteinDistance {
    public static int calculateDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Initialize the first row and column
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        // Calculate the distance
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) throws IOException {
//        String s1 = "kitten";
//        String s2 = "sitting";
//        int distance = calculateDistance(s1, s2);
//        System.out.println("Levenshtein distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + distance);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter text 1:");
        String text1 = br.readLine();

        System.out.println("Enter text 2:");
        String text2 = br.readLine();

        int result = calculateDistance(text1, text2);
        System.out.println("Length of Longest Common Subsequence (LCS): " + result);
    }
}
