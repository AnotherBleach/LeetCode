package Permutation;

import org.junit.Test;

import java.util.*;

public class Solution {
    private static int index = 0;

    public List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (index == nums.length) {

            List<Integer> temp = new ArrayList<Integer>();
            result.add(temp);
        } else if (index == nums.length - 1) {

            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[index]);
            result.add(temp);

        } else {

            index++;
            List<List<Integer>> result2 = permute(nums);
            index--;
            for (Iterator<List<Integer>> it = result2.iterator(); it.hasNext(); ) {
                List<Integer> temp = it.next();//[2,3,4]
                for (int i = 0; i < temp.size(); i++) {

                    List<Integer> real = new ArrayList<Integer>();
                    real.addAll(temp);
                    real.add(i, nums[index]);
                    result.add(real);
                }
                List<Integer> real = new ArrayList<Integer>();
                real.addAll(temp);
                real.add(nums[index]);
                result.add(real);

            }

            Set<List<Integer>>sets = new HashSet<List<Integer>>();
            sets.addAll(result);
            List<List<Integer>>lists = new ArrayList<List<Integer>>();
            lists.addAll(sets);
            result = lists;


        }


        return result;

    }

    @Test
    public void testPermute() {

        int[] nums = {1,1,2};
        List<List<Integer>> result = permute(nums);
        for (Iterator<List<Integer>> it = result.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

    }

}