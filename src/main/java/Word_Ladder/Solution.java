package Word_Ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 1、Only one letter can be changed at a time.
     * 2、Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList.contains(endWord)) {
            List<String> used = new ArrayList<>();

            if (wordList.contains(beginWord))
                used.add(beginWord);

            return handle(beginWord, endWord, wordList, used);


        }
        return 0;

    }

    // recursive version
    // ok，but tle，do not use dfs,use bfs;
    private int handle(String beginWord, String endWord, List<String> wordList, List<String> used) {

        if (beginWord == endWord)
            return 1;
        int minsize = Integer.MAX_VALUE;
        int wordLength = wordList.size();
        for (int i = 0; i < wordLength; i++) {
            String word = wordList.get(i);
            if (used.contains(word)) continue;
            if (!isOk(beginWord, word)) continue;

           // System.out.print(beginWord + "->" + word+" ");
            if (word.equals(endWord)) {
               return 2;
            }
            used.add(word);
            int x = 1 + handle(word, endWord, wordList, used);
            if(x == 1)
                x=0;

            used.remove(used.size() - 1);
            if(x!=0)minsize = Math.min(minsize, x);


        }

        if (minsize == Integer.MAX_VALUE)
            return 0;
        return minsize;


    }

    private boolean isOk(String word, String next) {


        int times = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != next.charAt(i)) {
                if (times == 1)
                    return false;
                times++;

            }

        }

        return true;
    }


    @Test
    public void test() {


        List<String> word = new ArrayList<>();
        word.add("hot");
        word.add("dot");
        word.add("dog");
        word.add("lot");
        word.add("log");
        word.add("cog");
        //shortest path with bfs


        System.out.println(ladderLength("hit", "cog", word));

    }


}
