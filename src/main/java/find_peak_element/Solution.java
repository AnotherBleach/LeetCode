package find_peak_element;

import org.junit.Test;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return 0;
        if (nums.length == 2) {
            if (nums[0] > nums[1]) return 0;
            return 1;
        }

        boolean first = true;
        boolean pre = false;
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {

            temp = nums[i] - nums[i - 1];
            if (first == true) {
                first = false;
                if (temp < 0) {
                    pre = false;
                } else {

                    pre = true;
                }


            } else {

                if (temp < 0 && pre) return i - 1;

                if (temp < 0) {
                    pre = false;
                } else {
                    pre = true;
                }

            }


        }


        // 0 or n-1

        if(nums[0]>nums[1])return 0;
        return nums.length-1;


    }

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{1,2,3}));


    }

}
