package Insert_Interval;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        Interval tail = null;
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        boolean notok = true;
        for(int i=0;i<intervals.size();i++)
        {
            if(newInterval.start<intervals.get(i).start)
            {

                intervals.add(i,newInterval);
                notok=false;
                break;
            }


        }
        if(notok)intervals.add(newInterval);



        for (Iterator<Interval> it = intervals.iterator(); it.hasNext(); ) {

            Interval now = it.next();
            if (result.size() == 0) {
                result.add(now);
                tail = now;

            } else {
                if (tail.end < now.start) {

                    result.add(now);
                    tail = now;

                } else if (tail.end == now.start) {

                    tail.end = now.end;

                } else if (tail.end > now.start && tail.start <= now.start) {

                    tail.end = Math.max(tail.end, now.end);

                }


            }


        }

        return result;
    }

    @Test
    public void test() {

        List<Interval>temp = new ArrayList<>();
        Interval a1 = new Interval(1,5);
       // Interval a2 = new Interval(3,5);
//        Interval a3 = new Interval(6,7);
//        Interval a4 = new Interval(8,10);
//        Interval a5 = new Interval(12,16);
        temp.add(a1);
 //       temp.add(a2);
//        temp.add(a3);
//        temp.add(a4);
//        temp.add(a5);
        List<Interval>lists = insert(temp,new Interval(1,7));
        System.out.println(Arrays.deepToString(lists.toArray()));


    }


}
