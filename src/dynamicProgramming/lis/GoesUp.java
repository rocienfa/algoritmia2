package dynamicProgramming.lis;

import java.util.ArrayList;
import java.util.Arrays;

public class GoesUp {
    private static ArrayList<Integer> findLongestIncreasingSubsequence(ArrayList<Integer> sequence) {
        int n = sequence.size();

        int[] lengthList = new int[n];
        int[] indices = new int[n];

        // Initialize LIS lengths
        Arrays.fill(lengthList, 1);
        Arrays.fill(indices, -1);

        int maxLength = 0, endElementIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.get(i) > sequence.get(j) && lengthList[i] < lengthList[j] + 1) {
                    lengthList[i] = lengthList[j] + 1;
                    indices[i] = j;
                }
            }

            if (lengthList[i] > maxLength) {
                maxLength = lengthList[i];
                endElementIndex = i;
            }
        }

        ArrayList<Integer> listResult = new ArrayList<>();

        while (endElementIndex != -1) {
            listResult.add(0, endElementIndex);
            endElementIndex = indices[endElementIndex];
        }

        return listResult;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(
                Arrays.asList(-7, 10, 9, 2, 3, 8, 8, 6)
        );

//        ArrayList<Integer> input = new ArrayList<>(
//                Arrays.asList(1, 3, 3, 1, 2)
//        );

        ArrayList<Integer> lisSubsequence = findLongestIncreasingSubsequence(input);

        System.out.println(lisSubsequence.size());
        System.out.println("-");

        for (int s : lisSubsequence) {
            System.out.println(input.get(s));
        }
    }
}
