package Minimum_Path_Sum;

import org.junit.Test;

public class Solution {
    public int minPathSum(int[][] grid) {

        if (grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[row][col];
        ans[row-1][col-1]=grid[row-1][col-1];
        for(int j=col-2;j>=0;j--)
        {
            ans[row-1][j] = ans[row-1][j+1]+grid[row-1][j];
        }//最后一行

        for(int j=row-2;j>=0;j--)
        {
            ans[j][col-1] = ans[j+1][col-1]+grid[j][col-1];
        }//最后一列

        for(int i=row-2;i>=0;i--)
            for(int j=col-2;j>=0;j--) {

                ans[i][j] = Math.min(ans[i][j + 1],ans[i+1][j]) + grid[i][j];

        }

        return ans[0][0];

    }

    @Test
    public void test() {

        System.out.println(minPathSum(new int[][]{{1,2},{1,1}}));

    }

}
