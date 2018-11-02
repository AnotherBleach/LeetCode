package Target_Sum;

public class Solution {


    /**
     *
     * use dfs,it is accepted,but a little slow
     * where there is a dfs, there is a dp
    public int findTargetSumWays(int[] nums, int S) {

        return calc(nums,0,0,S);
    }
    public int calc(int[] nums,int currentNumber,int layer,int target)
    {
        if(layer == nums.length)
        {
            if(currentNumber == target)
                return 1;
                return 0;

        }
        int plus = calc(nums,currentNumber+nums[layer],layer+1,target);

        int minus = calc(nums,currentNumber-nums[layer],layer+1,target);


        return plus+minus;
    }
*/


}
