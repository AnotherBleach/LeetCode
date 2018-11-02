package Array_Nesting;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {
    public int arrayNesting(int[] nums) {
       int max = 0;
       boolean[] used = new boolean[20001];
       Set<Integer> sets = new HashSet<>();
       for(int i=0;i<nums.length;i++)
       {
           sets.clear();
           int temp = nums[i];

           while(used[temp]==false&&!sets.contains(temp))
           {
               sets.add(temp);
               used[temp]=true;
               temp = nums[temp];

               CopyOnWriteArrayList coal;

           }
           max = Math.max(max,sets.size());



       }



       return max;
    }
}
