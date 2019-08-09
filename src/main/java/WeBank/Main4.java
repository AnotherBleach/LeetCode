package WeBank;

import java.math.BigInteger;
import java.util.*;

public class Main4 {
    public static void main(String[] args) {

        int t;
        Scanner sc = new Scanner(System.in);
        int[] data = new int[sc.nextInt()];
        for (int i = 0; i < data.length; i++)
            data[i] = sc.nextInt();

        for (int i = 0; i < data.length; i++) {
            int count = 0;
            BigInteger temp = BigInteger.valueOf(data[i]);
            Set<BigInteger> set = new HashSet<>();
            boolean flag = true;
            while (flag && temp.compareTo(BigInteger.ONE) != 0) {
//                if (set.contains(temp)) {
//
//                    System.out.println("-1");
//                    flag = false;
//                    continue;
//
//
//                }
                if (temp.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) // 偶数
                {
                    temp = temp.divide(BigInteger.valueOf(2));


                } else temp = temp.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);

                set.add(temp);
                count++;

            }

            if(flag)System.out.println(count);

        }


    }
}
