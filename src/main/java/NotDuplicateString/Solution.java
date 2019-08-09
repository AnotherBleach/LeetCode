package NotDuplicateString;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Solution {
    //Insert one char from stringstream
    char c = '#';
    StringBuffer sb = new StringBuffer();
    Map<Character, Integer> counter = new HashMap<Character, Integer>();
    int index = 0;

    public void Insert(char ch) throws InterruptedException {
        // System.out.println("ch = "+ ch +counter.get(ch));
        if (ch != c) {
            if (c == '#' && counter.containsKey(ch) == false) c = ch;
            sb.append(ch);
            if (!counter.containsKey(ch))
                counter.put(ch, 1);
            else counter.put(ch, counter.get(ch) + 1);

        } else {
            if (!counter.containsKey(ch))
                counter.put(ch, 1);
            else counter.put(ch, counter.get(ch) + 1);

            String str = sb.toString();
            for (; index < str.length(); index++) {
                if (counter.get(str.charAt(index)) == 1)
                    break;
            }


        //    System.out.println(index+" ");


            if (index < str.length())
                c = str.charAt(index);
            else
                c = '#';

          //  System.out.println("c = "+c);
          //  TimeUnit.SECONDS.sleep(10);

        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return c;
    }

    @Test
    public void test() throws InterruptedException {
        String data = "google";
        for (int i = 0; i < data.length(); i++) {
            Insert(data.charAt(i));
             System.out.print(FirstAppearingOnce());
        }

    }
}