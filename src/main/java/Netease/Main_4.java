package Netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Another
 */
public class Main_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        boolean containsOdd = false;
        boolean containsEven = false;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {

                containsEven = true;
            } else {

                containsOdd = true;
            }
            if (containsEven && containsOdd) {
                break;
            }

        }
        if (containsEven && containsOdd) {
            Arrays.sort(nums);
        }

        for(int i=0;i<nums.length;i++){
            if(i!=0) {
                System.out.print(" ");
            }
            System.out.print(nums[i]);
        }
    }

}
