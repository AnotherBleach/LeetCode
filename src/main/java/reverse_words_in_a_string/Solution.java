package reverse_words_in_a_string;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        String temp = "";
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.equals("")) continue;
                else {
                    if (result.length() == 0) result.append(temp);
                    else result.insert(0,temp + " ");

                    temp = "";
                }

            } else {

                temp = temp + s.charAt(i);
            }

        }

        if(!temp.equals("")) {

          if(result.length()!=0)  result.insert(0,temp + " ");
            else result.append(temp);
        }
        return result.toString();
    }

    @Test
    public void test() {

        System.out.println(reverseWords("the     sky is blue       "));
        String[] words = "the sky  is blue".split(" ");
        Arrays.stream(words).forEach((x)->{
            System.out.println("x ="+x+"!");
            System.out.println(x.length());
        });

    }

}
