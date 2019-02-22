package removeduplicatesfromsortedarray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if(nums.length == 1)return 1;


        int slow = 0;
        int fast = 1;
        while(fast<nums.length)
        {

            if(nums[fast]==nums[slow])fast++;
            else {nums[++slow] = nums[fast];fast++;}

        }



        return slow+1;
    }
}
