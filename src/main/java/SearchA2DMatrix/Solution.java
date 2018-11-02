package SearchA2DMatrix;

import org.junit.Test;

public class Solution {

    private int searchRow(int[][] matrix, int target) {
        if (matrix.length == 0)
            return -1;
        if(matrix[0].length == 0)
            return -1;
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix[0][0] == target) return 0;
        if (matrix[0][0] > target) return -1;
        if (matrix[row - 1][0] <= target) return row - 1;
        //core------
        int p = 0, q = row - 1;
        while (p <= q) {

            int mid = (p + q) / 2;
            if (matrix[mid][0] == target)
                return mid;
            if(matrix[mid][0] > target)
                q = mid-1;
            if(matrix[mid][0]<target)
                p=mid+1;

        }
        //core------


        return q;
    }

    private int searchCol(int[][] matrix, int targetRow, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix[targetRow][0] == target || matrix[targetRow][col - 1] == target)
            return 1;
        if (matrix[targetRow][col - 1] < target)
            return -1;

        int p = 0, q = col - 1;
        while (p <= q) {
            int mid = (p + q) / 2;
            if (matrix[targetRow][mid] == target)
                return 1;
            if (matrix[targetRow][mid] < target) p = mid + 1;
            if (matrix[targetRow][mid] > target) q = mid - 1;

        }

        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {


        int row = searchRow(matrix, target);

        if (row == -1) return false;
        int col = searchCol(matrix, row, target);
        if (col == -1) return false;
        return true;

    }
    @Test
    public void testSearchMatrix()
    {
        //{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}}
        //
        int [][] matrix2 = new int[][]{{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}};
        int[][]matrix = new int[][]{{1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};

        System.out.println(searchMatrix(matrix2,0));
        //System.out.println(searchMatrix(matrix,13));

    }


}
