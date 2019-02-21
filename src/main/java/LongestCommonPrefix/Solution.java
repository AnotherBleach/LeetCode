package LongestCommonPrefix;

import org.junit.Test;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        char c;
        for (int i = 0; ; i++) {
            try {
                c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++)
                    if (strs[j].charAt(i) != c)
                        throw new Exception();

            } catch (Exception e) {

                return strs[0].substring(0, i);
            }

        }

    }

    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }

}
