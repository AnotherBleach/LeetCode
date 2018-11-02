package Power;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    //normal
//    public double myPow1(double x, int n) {
//        if (n == 0)
//            return 1;
//        double result = 1;
//        boolean negative = false;
//        if (n < 0) {
//            n = -n;
//            negative = true;
//        }
//        while ((n--) != 0) {
//            result *= x;
//
//        }
//        if(negative)return 1/result;
//        return result;
//    }

    //fast
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        if(n==Integer.MIN_VALUE)return 0.0;

        Map<Integer, Double> stores = new HashMap<Integer, Double>();
        double result = x;
        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }
        int times = 1;
        stores.put(times, result);

        while (times <= (n >> 1)) {

            result *= result;

            times <<= 1;
            stores.put(times, result);
        }
        int left = n - times;
        //System.out.println(left);
        times = 1;
        //get data from store;
        while (left != 0) {
            if (left % 2 != 0)
                result = result * stores.get(times);
            left /= 2;
            times <<= 1;

        }

        if (negative) return 1 / result;
        return result;
    }

    @Test
    public void test() {
        double x = 5;
        int n = 9;
       System.out.println(mypow(x, n));
        //System.out.println(3>>1);
       // System.out.println(-Integer.MIN_VALUE);
        //System.out.println(-Integer.MAX_VALUE);
    }

    //fatest
    public double mypow(double x,int n)
    {
        double result=1;
        double base = x;
        while(n!=0)
        {
            if(n%2==1)result*=base;
            base*=base;
            n/=2;
        }



        return  result;



    }


}