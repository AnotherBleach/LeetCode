package Netease;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Another
 */
public class Main_1 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] score = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
        }
        int[] copy_score_sort = Arrays.copyOfRange(score, 0, n);
        Arrays.sort(copy_score_sort);
        // 次数
        int times = scanner.nextInt();
        int student = 0;
        while (times != 0) {

            student = scanner.nextInt();
            int my_score = score[student-1];
            int pos = Arrays.binarySearch(copy_score_sort, my_score);
            while(pos+1<copy_score_sort.length&&copy_score_sort[pos+1]==my_score)
            pos++;
            System.out.printf("%.6f",(pos*100)/(double)n);
            times--;
        }
    }

}
