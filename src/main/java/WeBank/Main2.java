package WeBank;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
         long  n, k, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        m = scanner.nextInt();

        if (m >= n) {
              System.out.println(k);
        } else {
             long data = 0;
             long  group = n / m;
            data = data + (group * k);
             long  left = n % m;
            if (left != 0)
                data = data + k;

            System.out.println(data);
        }
    }
}
