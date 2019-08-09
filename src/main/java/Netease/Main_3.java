package Netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Another
 */

public class Main_3 {


    public static void main(String[] args) {

        long[] a = new long[100001];
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- != 0) {

            int n = scanner.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextLong();
            }
            Arrays.sort(a, 0, n);
            if (a[n - 1] < a[n - 2] + a[n - 3]) {

                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
