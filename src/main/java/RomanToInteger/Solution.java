package RomanToInteger;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> bank = new HashMap<>();
        int money = 0;

        bank.put("I", 1);
        bank.put("V", 5);
        bank.put("X", 10);
        bank.put("L", 50);
        bank.put("C", 100);
        bank.put("D", 500);
        bank.put("M", 1000);
        bank.put("IV", 4);
        bank.put("IX", 9);
        bank.put("XL", 40);
        bank.put("XC", 90);
        bank.put("CD", 400);
        bank.put("CM", 900);
        int len = s.length();
        for (int i = 0; i < len; ) {
            char c = s.charAt(i);
            if (c != 'I' && c != 'X' && c != 'C') {
                money += bank.get(c+"");
                i++;
            } else {

                if (i + 1 < len && bank.containsKey(s.substring(i, i + 2))) {
                    money += bank.get(s.substring(i, i + 2));
                    i += 2;

                } else {

                    money += bank.get(c+"");
                    i++;
                }
            }
            System.out.println(money);

        }

        return money;
    }

    @Test
    public void test() {


        System.out.println(romanToInt("MCMXCIV"));
    }


}
