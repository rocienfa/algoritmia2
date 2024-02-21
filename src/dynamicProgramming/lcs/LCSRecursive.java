package dynamicProgramming.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCSRecursive {
    private static int lcsRecursive(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (text1.charAt(i) == text2.charAt(j)) // when the letters are same
            return 1 + lcsRecursive(text1, text2, i + 1, j + 1);
        else
            return Math.max(
                    lcsRecursive(text1, text2, i + 1, j),
                    lcsRecursive(text1, text2, i, j + 1)
            );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter text 1:");
        String text1 = br.readLine();

        System.out.println("Enter text 2:");
        String text2 = br.readLine();

        int result = lcsRecursive(text1, text2, 0, 0);
        System.out.println("Length of Longest Common Subsequence (LCS): " + result);
    }
}
