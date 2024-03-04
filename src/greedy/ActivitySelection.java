package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ActivitySelection {
    static void maximumActivities(Activity[] activities) {
        int n = activities.length;

        Arrays.sort(activities, new Activity(0, 0));

        System.out.println("Following activities are selected:");

        int i = 0;
        System.out.println("(" + activities[i].start + ", " + activities[i].finish + ")");

        for (int j = 1; j < n; j++) {
            if (activities[j].start >= activities[i].finish) {
                System.out.println("(" + activities[j].start + ", " + activities[j].finish + ")");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = 6;
        Activity[] activities = new Activity[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Enter the start and end time of activity " + (i + 1) + ":");

            int start = scanner.nextInt();
            int finish = scanner.nextInt();

            activities[i] = new Activity(start, finish);
        }

        maximumActivities(activities);
    }
}
