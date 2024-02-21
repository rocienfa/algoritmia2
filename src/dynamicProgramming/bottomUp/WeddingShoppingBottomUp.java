package dynamicProgramming.bottomUp;

import java.util.Scanner;

public class WeddingShoppingBottomUp {
    static int C, M;

    public static int shop(int money, int g) {
       return 0;
    }

    public static void main(String[] args) {
        int result = shop(M, 0);// g = 0
        if (result < 0)
            System.out.println("no solution");
        else
            System.out.println(result);
    }
}
