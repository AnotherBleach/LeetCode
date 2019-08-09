package Subsets;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Solution {
    private final String NAME = "James";
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        handle(new ArrayList<Integer>(),0,nums);
        return result;
    }

    public void handle(List<Integer> list, int index, int[] nums) {
        if (index < nums.length) {
            int data = nums[index];
            handle(list, index + 1, nums);
            list.add(data);
            handle(list, index + 1, nums);
            list.remove(list.size());

        } else {

            result.add(new ArrayList<>(list));

        }
    }

    @Test
    public void test()
    {

        try {
            Solution solution = new Solution();
            Field cls = Solution.class.getDeclaredField("NAME");
            cls.setAccessible(true);
            System.out.println("Before :"+solution.NAME);
            cls.set(solution,"100");
            System.out.println("After  :"+solution.NAME);
            System.out.println("Reflect :"+cls.get(solution));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}