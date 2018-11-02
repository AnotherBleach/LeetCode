package LetterCombination;

import org.junit.Test;

import java.util.*;
//stackoverflow
public class Solution {
    static  int index=0;

    Map<Character,String[]> dict = new HashMap<>();
     {

        dict.put('2',new String[]{"a","b","c"});
        dict.put('3',new String[]{"d","e","f"});
        dict.put('4',new String[]{"g","h","i"});
        dict.put('5',new String[]{"j","k","l"});
        dict.put('6',new String[]{"m","n","o"});
        dict.put('7',new String[]{"p","q","r","s"});
        dict.put('8',new String[]{"t","u","v"});
        dict.put('9',new String[]{"w","x","y","z"});
    }
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();
        if(index == digits.length()-1)
        {

              String[] datas = dict.get(digits.charAt(index));
            for(String data:datas)
            {
                result.add(data);

            }

        }
        else {
            index++;
            List<String> son = letterCombinations(digits);
            index--;
            List<String> realson = new ArrayList<>();
            for (Iterator<String> it = son.iterator(); it.hasNext(); ) {
                String temp = it.next();
                String[] datas = dict.get(digits.charAt(index));
                for (String data : datas) {
                    realson.add(data + temp);

                }
                result = realson;

            }
        }
        return result;

    }

    @Test
    public void testLetter()
    {
        for(Iterator<String>it = letterCombinations("234").iterator();it.hasNext();)
        {


            System.out.println(it.next());
        }
//        String digits="23";
//
//        System.out.println(dict.get(digits.charAt(0)));

    }

}