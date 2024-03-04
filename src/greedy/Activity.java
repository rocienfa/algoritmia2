package greedy;

import java.util.Comparator;

class Activity implements Comparator<Activity> {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compare(Activity a, Activity b) {
        return a.finish - b.finish;
    }
}