package TwoSums;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey(nums[i]))
                data.put(nums[i], data.get(nums[i]) + 1);
            else
                data.put(nums[i], 1);

        }
        for (int j = 0; j < 10; j++) {


        }

        return ans;

    }
}
