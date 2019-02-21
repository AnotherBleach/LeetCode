package Word_Ladder;

import org.junit.Test;

import java.util.*;

//TLE
public class SolutionIII {
//    public class GraphNode {
//
//        String word;
//        List<GraphNode>friends;
//
//        public GraphNode(String word) {
//            this.word = word;
//        }
//    }

    public boolean isOk(String a, String b) {
        int size = a.length();
        int diff = 0;
        for (int i = 0; i < size; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diff != 0) return false;
                diff++;
            }

        }
        return true;
    }

    //    public GraphNode  buildGraph(String beginWord, String endWord, List<String> wordList)
//    {
//        GraphNode start = new GraphNode(beginWord);
//        for(int i=0;i<wordList.size();i++)
//        {
//            if(isOk(beginWord,wordList.get(i)))
//                start.friends.add(new Gra)
//
//        }
//
//        return start;
//    }
//    public int bfs(GraphNode start,String endWord)
//    {
//
//        return 0;
//    }
    public int bfs(String beginWord, String endWord, List<String> wordList) {
        Map<String, String> pre = new HashMap<>();
        List<String> used = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.push(beginWord);
        int size = 0;
        boolean find = false;
        while (!queue.isEmpty()) {
            String top = queue.pop();
            if (top.equals(endWord)) {
                find = true;
                break;
            } else {

                for (String word : wordList) {
                    if (!used.contains(word) && isOk(word, top)) {
                        queue.add(word);
                        used.add(word);

                        pre.put(word, top);
                    }


                }

            }


        }

        if (!find)
            return 0;

        String temp = pre.get(endWord);
        size++;
        while (!temp.equals(beginWord)) {
            size++;
            temp = pre.get(temp);

        }
        size++;
        return size;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList.contains(endWord) == false)
            return 0;

        return bfs(beginWord, endWord, wordList);

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
        System.out.println(ladderLength("hit", "log", word));

    }
}
