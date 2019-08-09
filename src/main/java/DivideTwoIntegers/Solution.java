package DivideTwoIntegers;

import org.junit.Test;

public class Solution {

    public int divide(int dividend, int divisor) {

        long new_dividend = Math.abs(dividend);
        long new_divisor = Math.abs(divisor);


        long result = calc(new_dividend,new_divisor);
        if(result<Integer.MIN_VALUE||result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)result;
    }
    public long calc(long dividend,long divisor)
    {

        if(dividend<divisor)return 0;
        long now = calc(dividend/2,divisor);

        return 0;

    }
    @Test
    public void test()
    {

        System.out.println((-9/2) +" "+-9%2);
    }
}
