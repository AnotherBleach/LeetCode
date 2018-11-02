package RotateImage;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/description/
 */

public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int i = 0, p = 0; i < col && p < row; p++, i++) {
            for (int j = row - 1, q = 0; j >= 0 && q < col; j--, q++) {
                result[p][q] = matrix[j][i];

            }
        }
       for(int i=0;i<row;i++)
           for(int j=0;j<row;j++)
           {
               matrix[i][j]=result[i][j];

           }


    }

    @Test
    public void testRotate() {
        int[][] a = new int[][]{

                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        rotate(a);
        System.out.println(Arrays.deepToString(a));


    }

}