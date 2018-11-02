package SetZeroes;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public void setZeroes2(int[][] matrix)
    {
        boolean zeroInFirstCol = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                zeroInFirstCol = true;
                break;
            }
        }

        /**Column 0 keeps track of rows to zero
         Go from row 1 to n, whenever encounter 0, set row i col 0 to 0
         Afterwards, if any zeros were found, set all in col to 0 */
        for (int col = 1; col < matrix[0].length; col++) {
            boolean foundZero = false;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] == 0) {
                    foundZero = true;
                    matrix[row][0] = 0;
                }
            }
            if (foundZero) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        //Then, go through first column, set all rows w/ 0 to 0
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        //Then, if any 0s in first column, set all of first column to 0
        if (zeroInFirstCol) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    //method1
    public void setZeroes(int[][] matrix) {

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int rowlength = matrix.length;
        int collength = matrix[0].length;
        for (int i = 0; i < rowlength; i++)
            for (int j = 0; j < collength; j++) {
                if(matrix[i][j] == 0)
                {
                    row.add(i);
                    col.add(j);

                }


            }

        for(Iterator<Integer>it = row.iterator();it.hasNext();)
        {
            int line = it.next();
            for(int j=0;j<collength;j++)
                matrix[line][j]=0;


        }
        for(Iterator<Integer>it = col.iterator();it.hasNext();)
        {
            int line = it.next();
            for(int j=0;j<rowlength;j++)
                matrix[j][line]=0;


        }





    }
    @Test
    public void test()
    {
        int[][] matrix = new int[][]{{1,0,2},{4,5,2},{3,1,5}};
        setZeroes2(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

}
