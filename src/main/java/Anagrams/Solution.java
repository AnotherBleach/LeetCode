package Anagrams;

import org.junit.Test;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, Integer> judger = new HashMap<String, Integer>();
        int i = 0;
        for (String str : strs) {

            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String newstr = new String(temp);
            if (judger.get(newstr) == null) {

                List<String> strings = new ArrayList<String>();
                strings.add(str);
                judger.put(newstr, i);
                result.add(i, strings);
                i++;

            } else {

                result.get(judger.get(newstr)).add(str);

            }

        }

        return result;

    }

    @Test
    public void testgroupAnagrams() {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>result = groupAnagrams(strs);
        for(Iterator<List<String>>it = result.iterator();it.hasNext();)
        {
            System.out.println(it.next());



        }

    }


}