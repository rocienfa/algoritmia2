package dynamicProgramming.levenshteinDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LevenshteinDistance {
    public static int calculateDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (s1.equals(s2))
            return 0;

        int[][] dp = new int[n + 1][m + 1];

        // Calculate the distance
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);

                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        return dp[n][m];
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

        int distance = calculateDistance(text1, text2);
        System.out.println("Levenshtein distance between \"" + text1 + "\" and \"" + text2 + "\" is: " + distance);
    }
}
