package Word_Ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionII {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;
        return bfs(beginWord, endWord, wordList);

    }

    public int bfs(String beginWord, String endWord, List<String> wordList) {
        List<String> used = new ArrayList<>();
        Queue<String> stores = new LinkedList<>();
        stores.add(beginWord);

        int length = 0;
        while (!stores.isEmpty()) {

            int size = stores.size();
            String fa = stores.poll();
            for (int i = 0; i < size; i++) {
                    String word = wordList.get(i);
                    if(used.contains(word))continue;
                    //if(!isOk(word,))


            }

        }

        return length;
    }

    private boolean isOk(String word, String next) {
        if (word.equals(next)) return false;
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

//        List<String> word = new ArrayList<>();
//        word.add("hot");
//       word.add("dot");
//        word.add("dog");
//        word.add("lot");
//        word.add("log");
//        word.add("cog");
//        //shortest path with bfs
//
//
//        System.out.println(ladderLength("hit", "cog", word));
    }
}
