package greedy.test;

import java.util.Arrays;
import java.util.Collections;

public class Q4 {
    public static void main(String[] args) {
        int n = 6;

        int[] t1 = {12,6,4,8,11,9}; //elf's time
        // Sorting in ascending order
        Arrays.sort(t1);
        printTimes(t1);
        // [4,10,18,27,37,50]
        Integer[] t2 = {11,5,2,3,8,1}; //delivery time
        // Sorting in descending order
        Arrays.sort(t2, Collections.reverseOrder());
        for (Integer integer : t2) {
            System.out.print(integer + " ");
        }
        System.out.println();

        int minTime = 0;
        for (int i = 0; i < n; i++) {
            minTime += t1[i];
            t1[i] = minTime;
        }

        // t1[2, 6, 10, 16, 46]

        minTime = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(minTime + " < " + t1[i]);
            if (minTime < t1[i]) {
                minTime = t1[i];  // have to wait i'th present
                System.out.println("IF minTime = " + minTime);
            }
            minTime += t2[i];
            System.out.println("minTime = " + minTime);
        }

        System.out.printf("Smallest time: %d", minTime);
    }

    private static void printTimes(int[] times )
    {
        for (int time : times) {
            System.out.print(time + " ");
        }
        System.out.println();
    }
}
