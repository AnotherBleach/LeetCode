package CombinationSum;

import org.junit.Test;

import java.util.*;

public class Solution {

    int start;
    int stop;
    boolean first=true;
    //recursive version
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(first){
            start=0;
            stop=candidates.length-1;
            Arrays.sort(candidates);
            first=false;
        }
        Set<List<Integer>> result = new HashSet<List<Integer>>();

        for (int i = start; i <=stop; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            if (candidates[i] == target) {
                temp.add(target);
                result.add(temp);
                break;
            }
            if (candidates[i] > target)
                break;
            int now=start;
            start=i+1;
            List<List<Integer>> temp2 = combinationSum2(candidates,target-candidates[i]);
            start=now;
            for(Iterator<List<Integer>>it = temp2.iterator();it.hasNext();)
            {

               List<Integer>single =  it.next();
               single.add(candidates[i]);

            }

            result.addAll(temp2);

            new HashMap<String,String >().put("","");

        }

        List<List<Integer>>result2 = new ArrayList<List<Integer>>();
        for(Iterator<List<Integer>>it = result.iterator();it.hasNext();)
        {
            result2.add(it.next());

        }


        return result2;

    }

    @Test
    public void testSolution()

    {

        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>>result = new Solution().combinationSum2(candidates,target);
        System.out.println(Arrays.deepToString(result.toArray()));



    }
}
