package dynamicProgramming.lis;

public class LisRecursive {
    public static int lisRecursive(int[] sequence, int n) {
        if (n == 1)
            return 1;

        int currentLength, maxValue = 1;

        // Recursively get the length of the LIS ending at sequence[i]
        for (int i = 1; i < n; i++) {
            currentLength = lisRecursive(sequence, i);
            // First Iteration: -7 < 6 &&  2 > 1
            // maxValue = 2
            // i++ = 2
            // Second Iteration: 10 < 6 &&  2 > 1
            // maxValue = 2
            if (sequence[i - 1] < sequence[n - 1] && currentLength + 1 > maxValue) {
                maxValue = currentLength + 1;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] sequence = {-7, 10, 9, 2, 3, 8, 8, 6};
        int n = sequence.length;
        System.out.println("Length of LIS is " + lisRecursive(sequence, n));
    }
}
