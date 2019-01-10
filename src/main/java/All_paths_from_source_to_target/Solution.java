package All_paths_from_source_to_target;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution {
    private boolean[] used;
    private List tempPath;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) throws InterruptedException {

        tempPath = new ArrayList();
        used = new boolean[graph.length];
        calc(graph, 0, graph.length - 1);
        return result;
    }

    public void calc(int[][] graph, int from, int to) {

        tempPath.add(from);
        used[from]=true;
        for (int i = 0; i < graph[from].length; i++) {
            if (!used[graph[from][i]]) {

                if (graph[from][i] == to) {
                    List list = new ArrayList<>(tempPath);
                    list.add(to);
                    result.add(list);


                } else {

                    calc(graph, graph[from][i], to);

                 }

            }
        }
        used[from]=false;
        tempPath.remove(tempPath.size()-1);

    }

    @Test
    public void test() throws InterruptedException {

        System.out.println(Arrays.deepToString(allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}).toArray()));

    }
}

