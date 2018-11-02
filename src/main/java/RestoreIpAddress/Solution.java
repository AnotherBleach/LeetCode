package RestoreIpAddress;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int counter = 0;

    private boolean isValidIp(String result) {

        String[] ips = result.split(".");
        if (ips.length != 4) return false;
        for (String ip : ips) {
            try {
                Integer integer = Integer.parseInt(ip);
                if (integer > 255 && integer < 0) return false;
            } catch (NumberFormatException e) {
                return false;
            }

        }

        return true;

    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        calcFromIndex(s, new String(), s.length() - 1, result);
        calcFromIndex(s, new String(), s.length() - 2, result);
        calcFromIndex(s, new String(), s.length() - 3, result);
        return result;

    }

    public void calcFromIndex(String s, String temp, int position, List<String> result) {

        if (counter >= 3) {


            if (position <= 2 && position >= 0) {
                System.out.println(position);
                temp += s.substring(0, position + 1);
                System.out.println(temp);
                if (isValidIp(temp))
                    result.add(temp.substring(0, temp.length() - 1));

            }

        } else {

            //3个位置可能性
            String another = temp;
            counter++;
            another += s.charAt(position) + ".";
            calcFromIndex(s, another, position - 1, result);
            counter--;

            counter++;
            another += s.substring(position - 1, position + 1) + ".";
            calcFromIndex(s, another, position - 1, result);
            counter--;

            counter++;
            another += s.substring(position - 2, position + 1) + ".";
            calcFromIndex(s, another, position - 2, result);
            counter--;


        }


    }

    @Test
    public void testIps() {

        String str = "25525511135";
        System.out.println(Arrays.deepToString(restoreIpAddresses(str).toArray()));

    }


}
