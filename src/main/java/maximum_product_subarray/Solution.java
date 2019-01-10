package maximum_product_subarray;

import org.junit.Test;

//Accepted,but too slow!
public class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maxValue = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j >= 0; j--) {
            int max1 = nums[j];
            int pre = nums[j];
            for (int q = j + 1; q < nums.length; q++) {

                max1 = Math.max(max1, pre * nums[q]);//slow
                pre = pre * nums[q];//slow

            }

            maxValue = Math.max(max1, maxValue);

        }

        return maxValue;

    }

    @Test
    public void test() {

        System.out.println(maxProduct(new int[]{0, 2}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }
}
