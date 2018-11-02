package TheLongestNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Solution {

    private class MyComparator implements Comparator<String> {

        @Override
        public int compare(String  me, String  another) {

            if((me+another).compareTo(another+me)>0)
                return -1;
            else if((me+another).compareTo(another+me)<0)
            return 1;
            return 0;

        }
    }

    public String largestNumber(int[] nums) {


        String[] _nums = new String[nums.length];
        boolean allzero = true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0)
                allzero = false;
            _nums[i] = new String (nums[i]+"");
        }
        if(allzero)
            return "0";

        Arrays.sort(_nums,new MyComparator());
        return String.join("",_nums);

    }


    @Test
    public void testlarge() {


        System.out.println(largestNumber(new int[]{0,0,0}));
    }


    public String largestNumber333(int[] nums) {

        String result = "";
        boolean equals = true;
        String[] _nums = new String[nums.length];
        boolean[] used = new boolean[nums.length];
        int position = 0;
        char max = '0' - 1;
        char first = ' ';
        int times = nums.length;
        int compare = 0;

        for (int i = 0; i < nums.length; i++) {
            _nums[i] = new String(nums[i] + "");

        }

        while (times != 0) {
            times--;

            equals = true;
            max = '0' - 1;
            first = ' ';
            for (int i = 0; i < _nums.length; i++) {
                if (used[i])
                    continue;
                if (times == 0) {
                    result = result + _nums[i];
                    used[i] = true;
                    break;

                }

                if (compare >= _nums[i].length()) {
                    int tempCompare = _nums[i].length() - 1;
                    if (first == ' ')
                        first = _nums[i].charAt(tempCompare);
                    else {
                        if (first != _nums[i].charAt(tempCompare))
                            equals = false;
                    }

                    if (_nums[i].charAt(tempCompare) > max) {
                        max = _nums[i].charAt(tempCompare);
                        position = i;

                    }


                } else {
                    if (first == ' ')
                        first = _nums[i].charAt(compare);
                    else {
                        if (first != _nums[i].charAt(compare))
                            equals = false;
                    }
                    if (_nums[i].charAt(compare) > max) {
                        max = _nums[i].charAt(compare);
                        position = i;


                    }


                }


            }

            if (equals)
                compare = compare + 1;
            else {

                result = result + _nums[position];
                used[position] = true;


            }


        }


        return result;

    }

    @Test
    public void testCut() {
        String str = "1,2,3,";
        System.out.println(Arrays.deepToString(str.split(",")));

    }

    @Test
    public void testJoin() {

        String[] s = new String[]{"1", "2", "3"};
        String result = String.join("#", s);
        System.out.println(result);
    }

    @Test
    public void testLarge() {

        String result = largestNumber(new int[]{3, 30, 34, 5, 9, 1});
        System.out.println(result);

    }

    @Test
    public void testString() {


        System.out.println("9".compareTo("5"));
        System.out.println("9".compareTo("59"));
        System.out.println("30".compareTo("3"));
    }

}
