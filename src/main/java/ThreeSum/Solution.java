package ThreeSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int left, right, mid;
        left = 0;
        right = nums.length - 1;
        mid = left + 1;
        Arrays.sort(nums);
        while (left < nums.length - 2) {

            while (mid < right) {

                int res = nums[left] + nums[mid] + nums[right];
                if (res == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[mid]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while (mid < right && nums[mid] == nums[mid + 1]) mid++;
                    while (mid < right && nums[right] == nums[right - 1]) right--;


                } else if (res > 0) {
                    right--;

                } else {
                    mid++;
                }


            }

            left++;
            right=nums.length-1;
            mid=left+1;
        }

        return result;
    }

    @Test
    public void test() {

        List s = threeSum(new int[]{1, 2, -2, -1});
        System.out.println(Arrays.deepToString(s.toArray()));
    }
}
