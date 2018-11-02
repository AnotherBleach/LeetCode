package Combinations;

import org.junit.Test;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class Solution {
    //1~n, k
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        handle(n, k, result);
        return result;

    }

    public void handle(int n, int k, List<List<Integer>> result) {
        //边界条件
        if (k <= 0 || n <= 0) {
            return;

        }
        if (k == 1) {

            for (int i = 1; i <= n && n > 0; i++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                result.add(temp);

            }
            return;
        }
        if (n == 1) {

            if (k > 1) return;
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            result.add(temp);
        }


        //1~n-1,k

        handle(n - 1, k, result);

        //1~n-1,k-1
        List<List<Integer>> temp = new ArrayList<>();
        handle(n - 1, k - 1, temp);
        for (Iterator<List<Integer>> it = temp.iterator(); it.hasNext(); ) {

            List<Integer> v = it.next();
            v.add(n);
            result.add(v);

        }

    }

    @Test
    public void test()
    {
       List<List<Integer>>result =  combine(4,1);
        System.out.println(Arrays.deepToString(result.toArray()));
    }

}
