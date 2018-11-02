package MergeIntervals;

import org.junit.Test;

import java.util.*;

public class Solution {

    private static class IntervalComparator implements Comparator {


        @Override
        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval) o1;
            Interval i2 = (Interval) o2;
            return i1.start - i2.start;

        }
    }


    public static List<Interval> merge(List<Interval> intervals) {
        //sort before next job
        Collections.sort(intervals, new IntervalComparator());

        //job

        if (intervals.size() <= 1) return intervals;
        List<Interval> results = new ArrayList<>();
        Stack<Integer> start = new Stack<>();
        Stack<Integer> end = new Stack<>();
        int size = intervals.size();
        for (int i = 0; i < size; i++) {
            Interval temp = intervals.get(i);
            if (start.size() <= 0 || end.size() <= 0) {

                start.push(temp.start);
                end.push(temp.end);

            } else if (start.peek() <= temp.start && end.peek() >= temp.start) {

                if (temp.end > end.peek()) {
                    end.pop();
                    end.push(temp.end);

                }


            }//overlap
            else {
                Interval interval = new Interval(start.pop(), end.pop());
                results.add(interval);
                start.push(temp.start);
                end.push(temp.end);

            }


        }
        if (start.size() != 0) {
            Interval interval = new Interval(start.pop(), end.pop());
            results.add(interval);

        }
        return results;

    }

    public static void main(String[] args) {
        int nums = 0;
        Scanner scanner = new Scanner(System.in);
        List<Interval> intervals = new ArrayList<>();
        nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {

            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));

        }
        System.out.println(Arrays.deepToString(intervals.toArray()));


        List<Interval> results = merge(intervals);
        Interval[] RESULTS = new Interval[results.size()];
        results.toArray(RESULTS);
        System.out.println(Arrays.deepToString(RESULTS));
    }


}
