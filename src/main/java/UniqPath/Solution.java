package UniqPath;

import org.junit.Test;

public class Solution {

    public int uniquePaths(int m, int n) {

//      return calcPath(m, n, 1, 1);
        return calcPathWithDP(m, n);

    }
    //动态规划
    private int calcPathWithDP(int m, int n) {
        int[][] result = new int[n][m];
        for(int i=0;i<n;i++)
        {
            result[i][m-1]=1;

        }
        for(int i=0;i<m;i++)
        {
            result[n-1][i]=1;

        }
        for(int i=n-2;i>=0;i--)
        {


            for(int j=m-2;j>=0;j--)

                result[i][j] = result[i+1][j]+result[i][j+1];


        }


        return result[0][0];
    }

    //递归版  TLE
    //x--->m,y,--->n
    private int calcPath(int m, int n, int x, int y) {
        if (x == m && y == n)
            return 0;
        if (x == m) {
            return 1;
        }
        if (y == n) {
            return 1;
        }

        int right = calcPath(m, n, x + 1, y);
        int down = calcPath(m, n, x, y + 1);

        return right + down;
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(7, 3));

    }
}
