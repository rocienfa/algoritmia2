package dynamicProgramming.topDown;

import java.util.Scanner;

public class WeddingShopping {
    static int C, M;
    private static final int[][] costs = new int[25][25]; // costs[g=20][model=20]
    private static final int[][] memoization = new int[210][25]; // costs[M=20][G=20]

    public static int shop(int money, int g) {
        int result = -1;
        if(money < 0) return result; //no solution

        if (g == C) return  M - money;

        if (memoization[money][g] != -1) return memoization[money][g]; //this to obtain the result already computed

        //analysis for each different model
        for (int model = 1; model <= costs[g][0]; model++) { // try the different models
            result = Math.max(result, shop((money - costs[g][model]), g + 1));
        }

        return memoization[money][g] = result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //bufferReader
        int N; // N = number of test cases; M = money ; C number of garment
        N = scanner.nextInt(); // 3

        while (N-- > 0) // N test cases
        {
            M = scanner.nextInt();
            C = scanner.nextInt();

            for (int i = 0; i < C; i++) {
                int K = scanner.nextInt();
                costs[i][0] = K;
                for (int j = 1; j <= K; j++) {
                    costs[i][j] = scanner.nextInt();
                }
            }

            // initialize memoization table => top-down
            for (int i = 0; i < 210; i++) { // memoization[M<=200][G<=20]
                for (int j = 0; j < 25; j++) {
                    memoization[i][j] = -1;
                }
            }

            int result = shop(M, 0);// g = 0
            if (result < 0)
                System.out.println("no solution");
            else
                System.out.println(result);
        }
    }
}
