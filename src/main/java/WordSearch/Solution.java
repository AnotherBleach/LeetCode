package WordSearch;

import org.junit.Test;


/**
 * @author Another
 */
public class Solution {


    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (dfs(board, word.toCharArray(), i, j, 0)) {
                    return true;
                }

            }

        }
        return false;

    }

    public boolean dfs(char[][] board, char[] word, int x, int y, int index) {

        if (index >= word.length-1) {
            return true;
        }
        if (board[x][y] != word[index]) {
            return false;
        }


        board[x][y] ^= 256;

        int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < move.length; i++) {
            int next_x = x + move[i][0];
            int next_y = y + move[i][1];
            if (!(next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board[x].length)) {


                if (dfs(board, word, next_x, next_y, index + 1)) {
                    return true;
                }


            }
        }

        board[x][y] ^= 256;

        return false;
    }

    @Test
    public void test() {


        //char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
       // char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
       // System.out.println(exist(board, "AAB"));
        // System.out.println('A'^0xfffff);
        System.out.println(exist(new char[][]{{'a'}},"a"));
        System.out.println('a' ^ 0xffff ^ 0xffff);
    }
}
