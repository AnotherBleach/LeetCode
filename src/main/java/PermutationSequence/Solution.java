package PermutationSequence;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    private boolean[] used = new boolean[10];
    private static int[] fact = new int[10];

    static {
        fact[0]=1;
        for(int i=1;i<10;i++)
            fact[i]=fact[i-1]*i;
    }
    public String getPermutation(int n, int k) {
        //cantor algorithm
        String result = "";
        int quotient = 0;
        int mod = k-1;
        boolean[]used = new boolean[10];
        final int z=n;
        while(n--!=0)
        {
            quotient =  mod/fact[n];
            mod = mod%fact[n];
            for(int i=quotient+1;i<z;i++){
                if(used[i]==false){

                    result=result+i;
                    used[i]=true;
                    break;
                }

            }



        }


        return result;
    }

    @Test
    public void test() {

        System.out.println(getPermutation(5,96));
        // generate(4, 0, new int[4]);
    }


    public void generate(int n, int pos, int[] temp) {
        if (pos == n) {
            Arrays.stream(temp).forEach(x -> {

                System.out.print(x);
            });
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();


        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                temp[pos] = i;
                generate(n, pos + 1, temp);
                used[i] = false;


            }


        }

    }


    @Test
    public void testCalc() {


    }

}
