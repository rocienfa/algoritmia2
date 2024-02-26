package dynamicProgramming.levenshteinDistance;

public class LevenshteinDistanceRecursive {
    private static int editDistanceRecursive(int i, int j, String str1, String str2) {
        if (i == 0) {
            return j;
        }

        if (j == 0) {
            return i;
        }

        int result = 1 + Math.min(Math.min(
                        editDistanceRecursive(i, j - 1, str1, str2), // Insert
                        editDistanceRecursive(i - 1, j, str1, str2)), // Remove
                editDistanceRecursive(i - 1, j - 1, str1, str2) // Replace
        );

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            result = Math.min(result, editDistanceRecursive(i - 1, j - 1, str1, str2));
        }

        return result;
    }

    public static int editDistance(String str1, String str2) {

        int n = str1.length(), m = str2.length();

        return editDistanceRecursive(n, m, str1, str2);
    }

    public static void main(String[] args) {
        String s1 = "kittdgdfgdgdfgdfhhhhhhhhhhhhhhhdden";
        String s2 = "sittdfgggggggggggggggggggggggggggggggssssing";
        int distance = editDistance(s1, s2);
        System.out.println("Levenshtein distance between \"" + s1 + "\" and \"" + s2 + "\" is: " + distance);
    }
}
