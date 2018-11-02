package Length_of_Last_Word;

import org.junit.Test;

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] data = s.split(" ");
        if (data.length == 0) return 0;

        return data[data.length - 1].length();
    }

    @Test
    public void test() {

        System.out.println(lengthOfLastWord(" world   ello   "));

    }

}
