package WeBank;

import java.math.BigInteger;
import java.util.Scanner;



public class Main3 {
    public static void main(String[] args) {
        BigInteger n, k, m;
        Scanner scanner = new Scanner(System.in);
        n = BigInteger.valueOf(scanner.nextLong()) ;
        k = BigInteger.valueOf(scanner.nextLong()) ;
        m = BigInteger.valueOf(scanner.nextLong()) ;

        if (m.compareTo(n)>=0 ) {

            System.out.println(k);
        } else {
            BigInteger data = BigInteger.ZERO;
            BigInteger  group = n.divide(m) ;
            data = data.add (group.multiply(k) );
            BigInteger left = n.mod(m);
            if (left.compareTo(BigInteger.ZERO)!=0)
                data = data.add(k);

            System.out.println(data);
        }
    }
}
