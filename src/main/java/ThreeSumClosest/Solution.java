package ThreeSumClosest;

import org.junit.Test;

import java.util.Arrays;


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min_gap = Integer.MAX_VALUE;
        int target_num = -1;

        int left, right, mid;
        left = 0;
        right = nums.length - 1;
        mid = left + 1;
        Arrays.sort(nums);
        while (left < nums.length - 2) {

            while (mid < right) {

                int res = nums[left] + nums[mid] + nums[right];
                int real_gap = (res - target);
                if (real_gap != 0) {

                    if (Math.abs(real_gap) < Math.abs(min_gap)) {

                        min_gap = real_gap;
                        target_num = res;
                    }

                    if (real_gap > 0) {


                        right--;

                    } else {

                        mid++;

                    }


                } else {
                    return res;
                }


            }

            while(left<nums.length-2&&nums[left]==nums[left+1])left++;
            left++;
            right = nums.length-1;
            mid = left+1;

        }

        return target_num;
    }

    @Test
    public void test() {

    }
}
