package LongestSubsequence;

import org.junit.Test;

//  i------j
//d[i][j] = d[i+1][j-1]+2 if str[i]==str[j],else d[i][j] = max(d[i][j-1],d[i+1][j])
//i big j small
//
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] d = new int[len][len];
        for (int i = 0; i < len; i++) {
            d[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--)
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1) d[i][j] = d[i + 1][j - 1] + 2;
                    else d[i][j] = 2;

                } else d[i][j] = Math.max(d[i][j - 1], d[i + 1][j]);

            }


        return d[0][len - 1];
    }

    @Test
    public void test() {

        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}
