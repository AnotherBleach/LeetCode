package SingleNumberII;

import org.junit.Test;

public class Solution {
    //使用32位数组
    public int singleNumber(int[] nums) {
        int[] a = new int[32];
        for (int i = 0; i < nums.length; i++) {


            for (int index = 0; index < 32; index++) {
                a[index] = (a[index] + ((nums[i] >> index) & 1));
                a[index] = a[index] % 3;
            }

        }


        //calc the number;
        int result = 0;
        if (a[31] == 0) {
            for (int i = 0; i < 31; i++) {

                result = (int) (result + a[i] * Math.pow(2.0, i));

            }
        } else {

            for (int i = 0; i < 31; i++) {

                int x = a[i] == 1 ? 0 : 1;

                result = (int) (result + (x) * Math.pow(2.0, i));

            }
            result = -(result + 1);

        }


        return result;
    }

    //使用32位整数
    public int singleNumberII(int[] nums) {

        return 0;
    }

    @Test
    public void test() {

//        for (int i = 0; i < 32; i++) {
//
//            System.out.print(((-3) >> i) & 1);
//
//        }
        //    System.out.println();
        System.out.println(singleNumber(new int[]{-3,-3,233,-3}));
    }
}
