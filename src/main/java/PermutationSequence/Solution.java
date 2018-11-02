package PermutationSequence;

import org.junit.Test;

public class Solution {

    public String getPermutation(int n, int k) {
        //1,2,3,...,n
        // 4 , 9 ,2314
        String result = "";
        int line_size = calc(n-1);



        return result;
    }

    private int calc(int n) {
        int result = 1;
        for(int i=2;i<=n;i++)
            result*=i;
        return result;
    }
    @Test
    public void testCalc()
    {
        System.out.println(calc(9));

    }

}
