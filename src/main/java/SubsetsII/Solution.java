package SubsetsII;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution {
    //Accepted,but too slow;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> result2 = new HashSet<>();
        List<List<Integer>> result3 = new ArrayList<>();
        calc(result, nums, 0);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> temp = result.get(i);
            Collections.sort(temp);
            result2.add(temp);


        }
        result3.addAll(result2);


        return result3;
    }

    public void calc(List<List<Integer>> result, int[] nums, int index) {
        if (index >= nums.length)
            return;
        if (nums.length == 0)
            return;
        if (index == nums.length - 1) {

            List<Integer> re1 = new ArrayList<>();
            List<Integer> re2 = new ArrayList<>();
            re2.add(nums[index]);
            result.add(re1);
            result.add(re2);

        } else {

            calc(result, nums, index + 1);
            List<List<Integer>> lists = new ArrayList<>();
            for (Iterator<List<Integer>> it = result.iterator(); it.hasNext(); ) {
                List<Integer> old = it.next();
                List<Integer> temp = new ArrayList<>(old);
                temp.add(nums[index]);
                lists.add(temp);

            }
            result.addAll(lists);


        }


    }

    @Test
    public void test() {

        List<List<Integer>> result = subsetsWithDup(new int[]{1, 2, 1});
        System.out.println(Arrays.deepToString(result.toArray()));

    }

    @Test
    public void test2() {

        List<Integer> s = new ArrayList<>();
        s.add(2);
        s.add(3);
        List<Integer> b = s;
        b.add(1);
        System.out.println(Arrays.deepToString(b.toArray()));
        System.out.println(Arrays.deepToString(s.toArray()));
        System.out.println(s == b);

    }


}
