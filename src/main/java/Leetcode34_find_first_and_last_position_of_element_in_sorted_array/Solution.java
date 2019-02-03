package Leetcode34_find_first_and_last_position_of_element_in_sorted_array;

import org.junit.Test;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (target > nums[nums.length-1] || target < nums[0])
            return new int[]{-1, -1};
        int index = bs(nums, target);
        if (index == -1) return new int[]{-1, -1};
        int[] result = new int[2];
        int left, right;
        left = right = index;

        while (left >= 0 && nums[left] == target) left--;
        left++;

        while (right < nums.length && nums[right] == target) right++;
        right--;

        result[0] = left;
        result[1] = right;
        return result;
    }

    public int bs(int[] nums, int target) {

        int left = 0, right = nums.length;
        int index = (nums.length) / 2;//偏向右边

        while (left <= right) {

            if (nums[index] == target)
                return index;
            if (nums[index] > target)
                right = index - 1;
            else
                left = index + 1;
            index = (left+right)/2;
        }

        return -1;
    }

    @Test
    public void test()
    {

        System.out.println(bs(new int[]{5,7,7,8,8,10},6));
    }
}
