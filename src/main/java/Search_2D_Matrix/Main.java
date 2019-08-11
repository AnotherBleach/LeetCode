package Search_2D_Matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Another
 */
public class Main {
    public static void main(String[] args) {

        int m;
        int n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matix[i][j] = sc.nextInt();
            }
        }
        int target;
        target = sc.nextInt();
        System.out.println(searchMatrix(matix, target));

    }
    // 按行来，然后排出大量列
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int currentLine = 0;
        int forbidden = matrix[0].length;
        while (true) {
            if (currentLine >= matrix.length) {
                return false;
            }
            int pos = Arrays.binarySearch(matrix[currentLine], 0, forbidden, target);
            if (pos >= 0) {
                return true;
            }

            pos = -pos;
            if (pos == 1) {
                return false;
            }
            pos = pos - 1;
            if (pos >= forbidden) {
                currentLine++;
            } else {
                forbidden = pos;
            }


        }

    }

    @Test
    public void test() {
        int[] data = new int[]{1, 3, 5, 7, 9};
        System.out.println(Arrays.binarySearch(data, 0, 1, 3));
    }
}
