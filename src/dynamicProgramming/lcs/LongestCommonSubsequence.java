package dynamicProgramming.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int sizeText1 = text1.length();
        int sizeText2 = text2.length();

        int [][]dp = new int[sizeText1 + 1][sizeText2 + 1];

        for (int i = 1; i <= sizeText1; i++)
        {
            for (int j = 1; j <= sizeText2; j++)
            {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[sizeText1][sizeText2];
    }

    public static int longestCommonSubsequenceOpt2(String text1, String text2) {
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) return 0;

        int m = text1.length(), n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // JIC: dp[i][j]: longest subsequence in first i in text1 & first j in text2
        for (int i = 1; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter text 1:");
        String text1 = br.readLine();

        System.out.println("Enter text 2:");
        String text2 = br.readLine();

        int result = longestCommonSubsequence(text1, text2);
        //int result = longestCommonSubsequenceOpt2(text1, text2);

        System.out.printf("The longest common subsequence is \"%s\" and its length is %d.%n", text2, result);
    }
}
