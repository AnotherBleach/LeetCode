package BitMapSort;

import Bonus.Sanlie;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Sanlie sanlie = new Sanlie();


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] stores = new int[1001];
        int temp;
        int size = 0;
        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            stores[temp]++;
            if (stores[temp] == 1)
                size++;
        }
        System.out.println(size);
        boolean first = true;
        for (int i = 0; i < 1001; i++) {
            if (stores[i] != 0) {

                if (first) {
                    System.out.print(i);
                    first = false;
                } else System.out.print(" " + i);
            }
        }
        System.out.println();


    }
}
