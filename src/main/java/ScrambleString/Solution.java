package ScrambleString;


import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())return false;
        if(s1 == null)
            return true;
        if(s1.length() <= 1)
        {
            return s1.equals(s2);

        }
        if(s1.length()==2)
        {
            StringBuilder sb = new StringBuilder(s2);
            String s3 = sb.reverse().toString();
            return s1.equals(s3)||s1.equals(s2);

        }
        //保证都是相同字母
        char[] data_s1 = s1.toCharArray();
        char[] data_s2 = s2.toCharArray();
        Arrays.sort(data_s1);
        Arrays.sort(data_s2);
        for(int i=0;i<data_s1.length;i++)
            if(data_s1[i]!=data_s2[i])return false;
        //
        for(int i=1;i<s1.length();i++)
        {
            String s1_1 = s1.substring(0,i);
            String s1_2 = s1.substring(i);
            String s2_1 = s2.substring(0,i);
            String s2_2 = s2.substring(i);
            if(isScramble(s1_1,s2_1)&&isScramble(s1_2,s2_2))
                return true;
            s2_1 = s2.substring(0,s2.length()-i);
            s2_2 = s2.substring(s2.length()-i);
            if(isScramble(s1_1,s2_2)&&isScramble(s1_2,s2_1))
                return true;

        }

        return false;
    }
    @Test
    public void testScamble()
    {

        System.out.println(isScramble("great","rgtae"));
        System.out.println(isScramble("abcde","caebd"));
    }
}
