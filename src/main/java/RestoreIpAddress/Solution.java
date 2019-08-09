package RestoreIpAddress;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        if(s.length()>12)return null;
        String[] IP = new String [4];
        for (int i = 0; i < 3; i++)
            for (int j = i + 1; j < len; j++)
                for (int q = j + 1; q < len; q++) {

                        IP[0] = s.substring(0,i+1);
                        IP[1] = s.substring(i+1,j+1);
                        IP[2] = s.substring(j+1,q+1);
                        IP[3] = s.substring(q+1,len);
                        if(isVaildIP(IP)){
                            StringBuilder data = new StringBuilder();
                            data.append(IP[0]+".");
                            data.append(IP[1]+".");
                            data.append(IP[2]+".");
                            data.append(IP[3]);
                            result.add(data.toString());
                        }


                }

        return result;
    }

    private boolean isVaild(String s) {

        if (s.length() == 0 || s.length() > 3) return false;
        int num = Integer.parseInt(s);
        if(num==0&&s.length()==1)return true;
        return num > 0 && num <= 255;
    }

    private boolean isVaildIP(String[] s) {
        for (int i = 0; i < s.length; i++)
            if (!isVaild(s[i])) return false;
        return true;

    }
}