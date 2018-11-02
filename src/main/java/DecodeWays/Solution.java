package DecodeWays;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {

    boolean isValid(String str) {
        return str.length() != 0 && !str.startsWith("0");
    }

    //递归问题TLE，尝试转换到动态规划
    public int numDecodings(String s) {

        if (isValid(s)) {

            if (s.length() == 1)
                return 1;
            if (s.length() == 2) {
                Integer valurOfS = Integer.parseInt(s);
                if (valurOfS <= 26) {

                    if (valurOfS == 10 || valurOfS == 20)
                        return 1;
                    return 2;

                }
                if (s.indexOf("0") > -1)
                    return 0;
                return 1;

            }
            //(1~9)xxxxxx

            int one = 0, two = 0;
            if (isValid(s.substring(1))) {

                one = numDecodings(s.substring(1));

            }
            Integer temp = Integer.parseInt(s.substring(0, 2));
            if (temp <= 26)
                two = numDecodings(s.substring(2));
            return one + two;


        }
        return 0;

    }

    public int numDecodings2(String s) {
        if (isValid(s)) {


            if (s.length() == 1)
                return 1;
            if (s.length() == 2) {
                Integer valueOfS = Integer.parseInt(s);
                if (valueOfS <= 26) {

                    if (valueOfS == 10 || valueOfS == 20)
                        return 1;
                    return 2;

                }
                if (s.indexOf("0") > -1)
                    return 0;
                return 1;

            }



            //倒数第一个初始化
            int[] result = new int[s.length()];

            if (s.charAt(s.length() - 1) != '0')
                result[result.length - 1] = 1;
            else
                result[result.length - 1] = 0;

            //倒数第二个初始化
            if (s.charAt(s.length() - 2) >= '3')
                result[result.length - 2] = result[result.length-1];
            else {

                char now = s.charAt(s.length() - 2);
                if (now == '0')
                    result[result.length - 2] = 0;
                else {

                    if(now>'2')result[s.length()-2]=result[s.length()-1];
                    else if(now == '2'&&s.charAt(s.length()-1)>='7')result[s.length()-2]=1;
                    else result[s.length()-2]=result[s.length()-1]+1;


                }

            }

            LinkedBlockingQueue linkedBlockingQueue;
            ArrayBlockingQueue arrayBlockingQueue;

            for(int j=result.length-3;j>=0;j--)
            {

                if(s.charAt(j) == '0')result[j] = 0;
                else if(s.charAt(j)>='3')result[j] = result[j+1];
                else{

                    String temp = s.substring(j,j+2);
                    Integer numOfTemp = Integer.parseInt(temp);
                    if(numOfTemp>26)result[j] = result[j+1];
                    else if(numOfTemp == 20||numOfTemp == 10)result[j]=result[j+2];
                    else  result[j] = result[j+1]+result[j+2];



                }



            }
        return result[0];



        }

        return 0;
    }

    @Test
    public void test() {

        System.out.println(numDecodings2("7733"));
    }

}
