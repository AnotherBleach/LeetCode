package Combine_of_a_phone;

import org.junit.Test;

import java.util.*;

/**
 * @author Another
 */
public class Solution {

    Map<String, String> phone = new HashMap<>();

    public Solution() {

        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

    }

    public List<String> letterCombinations(String digits) {

        List<String>str = new ArrayList<>();
        calc(str,"23",0,new StringBuilder());
        return str;

    }

    private void calc(List<String> result, String template, int pos, StringBuilder current) {

        if (pos == template.length()) {

            result.add(current.toString());
        } else {

            char[] data = phone.get(template.charAt(pos)+"").toCharArray();
            for (int i = 0; i < data.length; i++) {

                calc(result, template, pos + 1, current.append(data[i]));
                current.deleteCharAt(current.length() - 1);
            }

        }
    }

    @Test
    public void test()
    {

        System.out.println(Arrays.deepToString(new List[]{letterCombinations("23")}));

    }
}
