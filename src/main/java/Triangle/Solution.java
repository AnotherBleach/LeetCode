package Triangle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //o(n) space----------start
        ;

        int size = triangle.size();
        int[][] data = new int[size][];
        int[][] ans = new int[size][];

        for (int i = 0; i < size; i++) {

            data[i] = new int[triangle.get(i).size()];
            ans[i] = new int[triangle.get(i).size()];
            for(int j=0;j<data[i].length;j++)
            {
                data[i][j] = triangle.get(i).get(j);

            }


        }
        //o(n) space----------stop
        for(int j=0;j<ans[size-1].length;j++)
        {
            ans[size-1][j] = data[size-1][j];

        }

        for(int row = size-2;row>=0;row--)
        {

            for(int col = ans[row].length-1;col>=0;col--)
            {

                ans[row][col] = Math.min(ans[row+1][col]+data[row][col],ans[row+1][col+1]+data[row][col]);


            }


        }




        return ans[0][0];
    }

    @Test
    public void test()
    {
        List<List<Integer>>data = new ArrayList<>();
        List<Integer>  line_1 = new ArrayList<>();
        line_1.add(2);


        List<Integer>  line_2 = new ArrayList<>();
        line_2.add(3);
        line_2.add(4);

        List<Integer>  line_3 = new ArrayList<>();
        line_3.add(6);
        line_3.add(5);
        line_3.add(7);

        List<Integer>  line_4 = new ArrayList<>();
        line_4.add(4);
        line_4.add(1);
        line_4.add(8);
        line_4.add(3);

        data.add(line_1);
        data.add(line_2);
        data.add(line_3);
        data.add(line_4);
       // System.out.println(Arrays.deepToString(data.toArray()));
        System.out.println(minimumTotal(data ));

    }
}
