package subarray_product_less_than_k;

import org.junit.Test;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k == 0) return 0;// 0<=k<10^6
        int[] f = new int[nums.length];
        if (nums[0] < k) f[0] = 1;
        else f[0] = 0;
        for (int j = 1; j < nums.length; j++) {

            int product = nums[j];
            int s = 0;
            if (product < k)
                s++;

            for (int q = j - 1; q >= 0; q--) { // too slow
                product = product * nums[q];
                if (product < k) s++;
                else break;

            }

            f[j] = f[j - 1] + s;

        }

        return f[nums.length - 1];
    }

    @Test
    public void test() {
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 1, 1}, 5));
    }
}
