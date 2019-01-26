package WordBreak;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null) return true;
        if (wordDict == null) return false;
        return calc(s, 0, wordDict);
    }

    //recursive tle reach！！！
    public boolean calc(String s, int start, List<String> wordDict) {

        if (start >= s.length()) return true;

        int size = s.length();
        for (int i = start; i < size; i++) {
            String temp = s.substring(start, i + 1);
            if (wordDict.contains(temp)) {

                if (calc(s, i + 1, wordDict))
                    return true;
            }
        }


        return false;
    }

    //AC ,but also can be optimized
    public boolean calc2(String s, List<String> wordDict) {

        boolean[][] res = new boolean[s.length()][s.length()];
        int length = s.length();
        for (int i = 0; i < length; i++)
            res[i][i] = wordDict.contains(s.substring(i, i + 1));

        for (int i = length - 1; i >= 0; i--)
            for (int j = i; j < length; j++) {

                if (wordDict.contains(s.substring(i, j + 1))) {
                    res[i][j] = true;
                    continue;
                }

                for (int k = i; k < j; k++)
                    if (res[i][k] && res[k + 1][j])
                        res[i][j] = true;

            }


        return res[0][s.length() - 1];

    }

    @Test
    public void test() {

        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        System.out.println(calc2("catsand", wordDict));
    }
}
