package DivideTwoInteger;

import org.junit.Test;

public class Solution {
    public int divide(int dividend, int divisor) {
        final int max = Integer.MAX_VALUE;



        return  dividend/divisor;
    }


    @Test
    public void testDivide()
    {
        System.out.println(7%-3);
        System.out.println(-7%3);
        System.out.println(divide(7,-3));
        System.out.println(divide(-7,3));

    }
}