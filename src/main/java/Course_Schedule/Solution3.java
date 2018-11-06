package Course_Schedule;

import java.util.LinkedList;
import java.util.Queue;

//easy to understand , topological sort with bfs
public class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int size = numCourses;
        int[] indegrees = new int[numCourses];
        int[][] connection = new int[numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
            indegrees[prerequisites[i][0]]++;//入度增加1
            connection[prerequisites[i][1]][prerequisites[i][0]]=1;//邻接矩阵记录连接情况

        }
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]==0) {
                queue.add(i);//可以优化
                size--;
            }

        }
        while(!queue.isEmpty())
        {
            Integer temp = ((LinkedList<Integer>) queue).pop();
            //从temp开始到的点，每个点入度减一
            for(int j=0;j<numCourses;j++)
                if(connection[temp][j]==1) {
                    connection[temp][j]=0;
                    indegrees[j]--;
                    if(indegrees[j]==0){size--;((LinkedList<Integer>) queue).push(j);}

            }


        }

        return size==0;
    }
}
