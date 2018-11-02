package MyCalendarI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyCalendar {

    List<Interval> stores;

    public List<Interval> getStores() {
        return stores;
    }

    private class Interval {
        private int start;
        private int stop;

        public Interval(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", stop=" + stop +
                    '}';
        }
    }



    public MyCalendar() {

        stores = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        Interval target = new Interval(start, end);
        int i;


        if (stores.size() == 0 || target.start >= stores.get(stores.size() - 1).stop) {
            stores.add(target);
            return true;
        }
        if (target.stop <= stores.get(0).start) {
            stores.add(0, target);
            return true;

        }


        int size = stores.size() - 1;
        boolean ok = false;
        for (i = 0; i < size; i++) {

            Interval left = stores.get(i);
            Interval right = stores.get(i + 1);
            if (target.start >= left.stop && target.stop <= right.start) {

                {
                    ok = true;
                    break;
                }

            } else if (target.start < left.stop)
                return false;

        }
        if (ok) {
            stores.add(i+1, target);
            return true;
        }


        return false;
    }

    public void handle(List<List<Integer>>data) {


    }

    @Test
    public void test() {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(20,29));
        System.out.println(calendar.book(13,22));
        System.out.println(calendar.book(44,50));
        System.out.println(calendar.book(1,7));
        System.out.println(calendar.book(2,10));
        System.out.println(calendar.book(14,20));
        System.out.println(calendar.book(19,25));
        System.out.println(calendar.book(36,42));
        for(Iterator<Interval>it = calendar.stores.iterator();it.hasNext();)
        {
            System.out.println(it.next());

        }

        System.out.println("-------------");
        System.out.println(calendar.book(21,29));
    }

}
