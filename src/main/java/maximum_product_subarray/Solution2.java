package maximum_product_subarray;

public class Solution2 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int result = Integer.MIN_VALUE;
        //max[i] 以i结尾的最大子数组
        //min[i] 以j结尾的最小子数组
        //max[0]=min[0]=nums[0]
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            result = Math.max(result, max[i]);
        }
        return result;
    }
}
