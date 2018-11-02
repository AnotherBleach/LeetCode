package NumberToRoman;

import org.junit.Test;

public  class Solution {
    public String intToRoman(int num) {

        //I             1
        //V             5------------
        //X             10----------
        //L             50------------
        //C             100----------
        //D             500----------
        //M             1000----------

        //IV            4
        //IX            9-----------
        //XL            40-----------
        //XC            90-----------
        //CD            400----------
        //CM            900----------

        //M CM XC IV  1994


        StringBuilder sb = new StringBuilder();
        //整除1000，等于几，添加几个M，再%1000,等于0，结束
        //整除900,等于几，添加几个CM.再%900，等于0,结束
        //整除1,
        int now = 0;

        now = num / 1000;
        while ((now--) != 0) sb.append("M");
        num = num % 1000;

        now = num / 900;
        while ((now--) != 0) sb.append("CM");
        num = num % 900;


        now = num / 500;
        while ((now--) != 0) sb.append("D");
        num = num % 500;

        now = num / 400;
        while ((now--) != 0) sb.append("CD");
        num = num % 400;

        now = num / 100;
        while ((now--) != 0) sb.append("C");
        num = num % 100;

        now = num / 90;
        while ((now--) != 0) sb.append("XC");
        num = num % 90;

        now = num / 50;
        while ((now--) != 0) sb.append("L");
        num = num % 50;

        now = num / 40;
        while ((now--) != 0) sb.append("XL");
        num = num % 40;


        now = num / 10;
        while ((now--) != 0) sb.append("X");
        num = num % 10;


        now = num / 9;
        while ((now--) != 0) sb.append("IX");
        num = num % 9;

        now = num / 5;
        while ((now--) != 0) sb.append("V");
        num = num % 5;

        now = num / 4;
        while ((now--) != 0) sb.append("IV");
        num = num % 4;

        now = num / 1;
        while ((now--) != 0) sb.append("I");

        return sb.toString();

    }

    @Test
    public void solutionTest() {

        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));


    }

}