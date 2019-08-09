package Netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Another
 */
public class Main_2 {
    public static void main(String[] args) {
        int n, q;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }


        int x;
        while (q != 0) {
            Arrays.sort(data);
            q--;
            x = sc.nextInt();
            int pos = Arrays.binarySearch(data,x);
            if(pos<0){
                if(x>data[data.length-1])
                {System.out.println(0);
                    continue;}

                for(int i=0;i<n;i++)
                    data[i]--;
                System.out.println(n);
                continue;
            }
            while(pos-1>=0&&data[pos-1]==x)pos--;
            int count=0;
            for(int i=pos;i<n;i++)
            {
                if(pos>=0)data[i]--;
                count++;
            }
            System.out.println(count);

        }

    }
}
