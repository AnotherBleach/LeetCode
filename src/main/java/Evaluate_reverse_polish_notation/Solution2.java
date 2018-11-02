package Evaluate_reverse_polish_notation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int length = 0;
        String[] temp = new String[]{"+", "-", "*", "/"};
        List<String> operators = Arrays.asList(temp);
        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];
            if (!operators.contains(token)) {
                stack[length] = Integer.parseInt(token);
                length++;
            } else {

                int x2 = stack[length-1];
                int x1 = stack[length-2];
                if(token.equals("+"))stack[length-2]=x1+x2;
                if(token.equals("-"))stack[length-2]=x1-x2;
                if(token.equals("*"))stack[length-2]=x1*x2;
                if(token.equals("/"))stack[length-2]=x1/x2;
                length--;

            }


        }


        return stack[length-1];
    }

    @Test
    public void test() {

        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
