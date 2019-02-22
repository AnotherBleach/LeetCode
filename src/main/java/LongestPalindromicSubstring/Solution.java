package LongestPalindromicSubstring;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    //recursive version
    private boolean isPalindrome(String s) {
        int len = s.length() - 1;
        int mid = s.length() / 2;
        for (int i = 0; i < mid; i++) {

            if (s.charAt(i) != s.charAt(len - i))
                return false;
        }
        return true;

    }


    public String longestPalindrome(String s) {//  边界条件


        char[] after = new char[s.length() * 2 + 1];
        for (int i = 0, j = 0; i < s.length(); i++) {
            after[j] = '#';
            j++;
            after[j] = s.charAt(i);
            j++;
        }
        after[after.length - 1] = '#';
        int mx = 0, id = 0;
        int[] p = new int[after.length];
        p[0] = 1;
        for (int i = 1; i < after.length; i++) {

            if (mx > i) {

                p[i] = Math.min(p[2 * id - i], mx - i);
            } else p[i] = 1;

            for (; i - p[i] >= 0 && i + p[i] <after.length && after[i + p[i]] == after[i - p[i]]; p[i]++) ;
            if (i + p[i] - 1 > mx) {

                mx = p[i] + i - 1;
                id = i;

            }


        }
        int max_len = p[0], pos = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > max_len) {
                max_len = p[i];
                pos = i;
            }

        }
        String temp = new String(Arrays.copyOfRange(after,pos-max_len+1,pos+max_len)).replace("#","");

        return temp;
    }

    public String calc(String s, int pos) {

        return "";

    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("cbbd"));

//        "#a#b#c#".chars().filter(new IntPredicate() {
//            @Override
//            public boolean test(int value) {
//                return value != '#';
//            }
//        }).forEach(x->{
//            System.out.print((char)x);
//        });
    }

}
