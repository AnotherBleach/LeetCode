package palindrome_partitioning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Another
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        handle(result, s);
        List<String>temp = new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            temp.add(s.substring(i,i+1));
        }

        result.add(temp);
        return result;
    }

    private void handle(List<List<String>> result, String s) {
        if (s.length() == 1) {

            List<String> res = new ArrayList<>();
            res.add(s);
            result.add(res);

            return;
        }
        for (int i = 1; i < s.length(); i++) {


            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            List<String> temp = new ArrayList<>();
            temp.add(left);
            temp.add(right);
            result.add(temp);
            List<List<String>> left_result = new ArrayList<>();
            List<List<String>> right_result = new ArrayList<>();
            handle(left_result, left);
            handle(right_result, right);
            left_result.forEach((left_list) -> {

                right_result.forEach((right_list) -> {

                    List<String> temp2 = new ArrayList<>();
                    temp2.addAll(left_list);
                    temp2.addAll(right_list);


                    if (temp2.size() != s.length()) {
                        result.add(temp2);
                    }
                });
            });


        }
    }

    @Test
    public void test() {

        System.out.println(Arrays.deepToString(new List[]{partition("a")}));
    }


}
