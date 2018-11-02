package Spiral_MatrixII;

import org.junit.Test;

import java.util.Arrays;

//按照爬行顺序填充数字

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] used = new boolean[n][n];
        int times = 0;
        int size = n * n;
        int data = 1;
        int x = 0, y = 0;
        while (times < size) {
            times++;

            while (y < n && used[x][y] == false) {
                result[x][y] = data++;
                used[x][y] = true;
                y++;

            }
            y--;
            x++;
            while (x < n && used[x][y] == false) {
                result[x][y] = data++;
                used[x][y] = true;
                x++;

            }
            x--;
            y--;

            while (y >= 0 && used[x][y] == false) {
                result[x][y] = data++;
                used[x][y] = true;
                y--;

            }
            y++;
            x--;

            while (x >= 0 && used[x][y] == false) {

                result[x][y] = data++;
                used[x][y] = true;
                x--;
            }
            x++;y++;


        }


        return result;
    }

    @Test
    public void test() {
        int[][] result = generateMatrix(3);
        System.out.println(Arrays.deepToString(result));

    }
}
