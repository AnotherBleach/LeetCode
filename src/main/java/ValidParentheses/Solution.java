package ValidParentheses;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {

        Stack<Character> left = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {

            if (left.empty()) {
                if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
                    return false;
                left.push(s.charAt(i));
            } else {

                if (left.peek() == '}' || left.peek() == ']' || left.peek() == ')')
                    left.push(s.charAt(i));
                else {

                    if((s.charAt(i)==')'&&left.peek()=='(')||(s.charAt(i)=='}'&&left.peek()=='{')||(s.charAt(i)==']'&&left.peek()=='['))
                        left.pop();
                    else left.push(s.charAt(i));
                }

            }


        }
        return left.isEmpty();
    }

}
