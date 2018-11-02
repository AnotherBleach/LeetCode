package N_QueensII;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<String>> result = new ArrayList<>();
    int[][] used;

    public List<List<String>> solveNQueens(int n) {
        used = new int[n][n];
        if (n == 0)
            return result;

        if (n == 1) {
            List<String> temp = new ArrayList<>();
            temp.add("Q");
            result.add(temp);
            return result;
        } else {
            char[][] data = new char[n][n];
            // "."
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    data[i][j] = '.';
            calc(0, data);

        }
        return result;
    }

    public void calc(int lines, char[][] puzzles) {

        if (lines >= puzzles.length) {
            List<String> data = new ArrayList<>();
            for (int i = 0; i < puzzles.length; i++) {

                String s = "";
                for (int j = 0; j < puzzles[0].length; j++) {
                    s = s + puzzles[i][j];

                }
                data.add(s);

            }

            result.add(data);
            return;
        }

        for (int j = 0; j < puzzles[0].length; j++)// 每一个可能的列
        {
            //puzzles[line-1][j]
            //puzzles[lines][j];
            boolean ok = true;
            for (int q = 0; q < lines; q++) {

                if (puzzles[q][j] == 'Q') {
                    ok = false;
                    break;
                }


            } //排除同一列
            if (ok) {
                //left
                int tempx = lines - 1;
                int tempy = j - 1;
                while (tempx >= 0 && tempy >= 0) {
                    if (puzzles[tempx][tempy] == 'Q') {
                        ok = false;
                        break;
                    }
                    tempx--;
                    tempy--;

                }
                //right
                if(ok){

                    tempx = lines-1;
                    tempy = j+1;
                    while (tempx >= 0 && tempy < puzzles[0].length) {
                        if (puzzles[tempx][tempy] == 'Q') {
                            ok = false;
                            break;
                        }
                        tempx--;
                        tempy++;

                    }


                }





            }//排除斜线


            if (ok) {
                puzzles[lines][j] = 'Q';
                calc(lines + 1, puzzles);
                puzzles[lines][j] = '.';


            }


        }

    }
    //超爽

    @Test
    public void test() {

        List<List<String>> result = solveNQueens(4);


    }


}
