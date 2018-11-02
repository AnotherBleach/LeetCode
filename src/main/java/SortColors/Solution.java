package SortColors;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public void sortColorsWith2pass(int[] nums) {

        int[] a=new int[3];
        for(int i=0;i<nums.length;i++)
        {
            a[nums[i]]++;

        }
        int j=0;
        for(int i=0;i<3;i++)
        {
            while (a[i]--!=0)
            {
                nums[j++]=i;

            }

        }
        for (int i:nums) {
            System.out.println(i);
        }


    }

    public void sortColorsWith1pass(int[] nums) {


    }

    @Test
    public void testOnePass()
    {

        sortColorsWith2pass(new int[]{2,0,2,1,1,0});

    }
}
