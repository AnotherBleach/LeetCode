package Lock;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[]A = new Integer[n];
        Integer[]B = new Integer[n];
        for(int i=0;i<n;i++)
            A[i]=in.nextInt();

        for(int i=0;i<n;i++)
            B[i]=in.nextInt();

        Arrays.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });
        Arrays.sort(B, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });

        boolean[] dead = new boolean[n];
        int win = 0;
        int equal=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(dead[j]==false){

                    if(A[i]-B[j]>0)//如果能够打败
                    {


                      //  System.out.println(A[i]+" beat "+B[j]);
                            win++;
                         dead[j]=true;
                        break;
                    }else if(A[i] == B[j]){

                        equal++;
                       // System.out.println(A[i]+" equal "+B[j]);
                        dead[j]=true;
                        break;
                    }

                }

            }

        }
        int lose = n-win-equal;
        int gap = (win-lose);
       // System.out.println(win+" "+equal+" "+lose);
        System.out.println(100*gap);
    }

}