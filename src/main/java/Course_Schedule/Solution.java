package Course_Schedule;

import org.junit.Test;


import java.util.concurrent.TimeUnit;
//Time Limited Exceed
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 1) return true;

        int lines = prerequisites.length;
        int[][] matrix = new int[numCourses][numCourses];

        for (int i = 0; i < lines; i++) {

            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            matrix[from][to] = 1;
            //build the graph

        }
        //
//        for (int j = 0; j < numCourses; j++) {
//            for (int i = 0; i < numCourses; i++)
//                System.out.print(matrix[j][i] + " ");
//            System.out.println();
//        }//

        boolean[] visited = new boolean[numCourses];
        int prev_points = -1;

        while (lines != 0) {
            //选择第i列
            prev_points = lines;
            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == false) {

                    int j;
                    for (j = 0; j < numCourses; j++) {
                        if (matrix[j][i] == 1) break;
                    }


//                    System.out.println(j);
//                    System.out.println(" "+i);


                    //全是0
                    if (j == numCourses) {

                    //    System.out.println("in");

                        visited[i] = true;
                        for (int p = 0; p < numCourses; p++) {

                            if(matrix[i][p]==1){matrix[i][p] = 0;
                            lines--;}

                        }

//                        for (int jj = 0; jj < numCourses; jj++) {
//                            for (int ii = 0; ii < numCourses; ii++)
//                                System.out.print(matrix[jj][ii] + " ");
//                            System.out.println();
//                        }
//                        System.out.println(lines);
//                        try {
//                            TimeUnit.SECONDS.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }



                    }




                }


            }
            if (lines == prev_points) return false;


        }


        return true;
    }

    @Test
    public void test() {

        System.out.println(canFinish(3, new int[][]{{1, 0}, {2, 0}}));

    }
}
