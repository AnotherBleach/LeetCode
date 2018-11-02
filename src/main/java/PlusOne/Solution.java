package PlusOne;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {

        if (digits.length == 1 && digits[0] == 0)
            return new int[]{1};
        int nineTimes = 0, firstNine = -1, lastNine = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                nineTimes++;
                if (firstNine == -1) firstNine = i;
                lastNine = i;

            }


        }
        if (nineTimes == digits.length) {

            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;

        } else {
            int[] result = new int[digits.length];
            digits[digits.length-1]++;
            int more=0;
            for(int j=digits.length-1;j>=0;j--)
            {
                result[j] = (digits[j]+more)%10;
                more = (digits[j]+more)/10;


            }
            return  result;
        }


    }

}
