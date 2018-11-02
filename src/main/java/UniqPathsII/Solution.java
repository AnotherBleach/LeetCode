package UniqPathsII;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] result = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {

            if (obstacleGrid[i][m - 1] == 1 || ((i < n - 1) && result[i + 1][m - 1] == 0))
                result[i][m - 1] = 0;
            else
                result[i][m - 1] = 1;


        }
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[n - 1][i] == 1 || ((i + 1 < m) && result[n - 1][i + 1] == 0))
                result[n - 1][i] = 0;
            else
                result[n - 1][i] = 1;

        }
        for (int i = n - 2; i >= 0; i--) {


            for (int j = m - 2; j >= 0; j--)
                if (obstacleGrid[i][j] == 1)

                    result[i][j] = 0;
                else
                    result[i][j] = result[i + 1][j] + result[i][j + 1];


        }
        ConcurrentLinkedQueue queue;


        return result[0][0];

    }

    @Test
    public void testUniquePath()
    {
        int[][]arr = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(arr));

    }

}
