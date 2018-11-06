package Course_Schedule;

import java.util.ArrayList;

//dfs find a circle in
public class Solution4 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] connection = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) connection[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++)
            connection[prerequisites[i][1]].add(prerequisites[i][0]);
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (!visited[i] && dfs(i, connection, visiting, visited)) return false;
        return true;

    }

    public boolean dfs(int i, ArrayList<Integer>[] connection, boolean[] visiting, boolean[] visited) {

        visiting[i] = true;
        for (int tmp : connection[i]) {
            if (visiting[tmp] || (!visited[tmp] && !dfs(tmp, connection, visiting, visited))) return false;

        }

        visiting[i] = false;
        visited[i] = true;

        return true;
    }

}
