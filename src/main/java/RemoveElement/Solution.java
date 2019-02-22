package RemoveElement;

public class Solution {
    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] == val) return 0;
            return 1;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {

            if (nums[fast] == val) fast++;
            else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
