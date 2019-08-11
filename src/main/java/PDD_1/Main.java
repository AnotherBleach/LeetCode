package PDD_1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Another
 */
public class Main {
    static double result = Double.MAX_VALUE;

    public static void main(String[] args) {

        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            double temp = calc(nums[i], nums[i+1], nums[i+2]);
            if (temp < result) {
                result = temp;
            }

        }
        System.out.printf("%.2f", result);


    }


    private static double calc(int a, int b, int c) {
        double avg = (a + b + c) / 3.0;
        double a_sq = (a - avg) * (a - avg);
        double b_sq = (b - avg) * (b - avg);
        double c_sq = (c - avg) * (c - avg);
        double total = a_sq + b_sq + c_sq;
        return total / 3;
    }

    @Test
    public void test() {

        System.out.printf("%.2f", calc(-1, 0, 1));
    }


}
