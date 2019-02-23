package UniqueBST;

import org.junit.Test;

public class SolutionII {

    //DP version
    //if dp[1][i-1]==0||dp[i+1][n]==0  result = result + dp[1][i-1]+dp[i+1][n]
    //else result = result +dp[1][i-1]*dp[i+1][n]

    public int numTrees(int n) {
        if (n <= 1) return n;
        int result = 0;
        int[][] dp = new int[n + 2][n + 2];
        //build dp  start
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = 2;
        }
        for (int i = n; i >=1 ; i--) {
            for (int j = i + 2; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    if (dp[i][k - 1] == 0 || dp[k + 1][j] == 0)
                        dp[i][j] = dp[i][j] + dp[i][k - 1] + dp[k + 1][j];
                    else dp[i][j] = dp[i][j] + dp[i][k - 1] * dp[k + 1][j];
                }
            }
        }

        //build dp  stop

        return dp[1][n];
    }
    @Test
    public void test()
    {
        System.out.println(numTrees(5));

    }


}
