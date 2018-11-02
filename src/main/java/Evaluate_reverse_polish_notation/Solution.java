package Evaluate_reverse_polish_notation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stores = new Stack();
        String[] temp = new String[]{"+", "-", "*", "/"};
        List<String> operators = Arrays.asList(temp);
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (operators.contains(token)) {

                int second = stores.pop();
                int first = stores.pop();
                if(token.equals("+"))stores.push(second+first);
                if(token.equals("-"))stores.push(first-second);
                if(token.equals("*"))stores.push(first*second);
                if(token.equals("/"))stores.push(first/second);


            } else
                stores.add(Integer.parseInt(token));


        }


        return stores.pop();
    }

    @Test
    public void test()
    {

        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
