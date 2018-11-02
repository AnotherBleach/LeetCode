package SpiralMatrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int[][] used = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                used[i][j] = 0;

            }

        int size = row * col;
        int nums = 0;
        int i = 0, j = 0;
        while (nums < size) {
            nums++;

            //--->
            while (j < col && used[i][j] == 0) {
                result.add(matrix[i][j]);
                used[i][j] = 1;
                j++;
            }
            j--;
            i++;


            // |
            // |
            // V
            while (i < row && used[i][j] == 0) {

                result.add(matrix[i][j]);
                used[i][j] = 1;
                i++;
            }

            i--;
            j--;

            //<---

            while (j >= 0 && used[i][j] == 0) {
                result.add(matrix[i][j]);
                used[i][j] = 1;
                j--;

            }
            j++;
            i--;


            // A
            // |
            // |

            while (i >= 0 && used[i][j] == 0) {
                result.add(matrix[i][j]);
                used[i][j] = 1;
                i--;

            }
            i++;
            j++;

        }
        return result;


    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(Arrays.deepToString(result.toArray()));

    }
}
