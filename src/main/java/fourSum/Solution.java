package fourSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int first, second, third, fourth;
        first = 0;
        second = first + 1;
        third = second + 1;
        fourth = nums.length - 1;

        while (first < nums.length - 3) {

            System.out.println("first = "+first);
            while (second < nums.length - 2) {
                System.out.println("second = "+second);
                while (third < fourth) {


                    int res = nums[second] + nums[third] + nums[fourth];
                    int exp = target-res;
                    if (exp==nums[first]) {

                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[third]);
                        temp.add(nums[fourth]);
                        result.add(temp);
                        while (third < fourth && nums[third] == nums[third + 1]) third++;
                        third++;
                        while (third < fourth && nums[fourth] == nums[fourth - 1]) fourth--;
                        fourth--;


                    } else if (exp > nums[first]) {

                        third++;

                    } else fourth--;


                }
                while (second < nums.length - 2 && nums[second] == nums[second + 1]) second++;
                second++;
                third = second + 1;
                fourth = nums.length - 1;


            }
            while (first < nums.length - 3 && nums[first] == nums[first + 1]) first++;
            first++;
            second=first+1;
            third = second + 1;
            fourth = nums.length - 1;



        }

        return result;

    }

    @Test
    public void test() {

        List<List<Integer>>data = fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
        System.out.println(Arrays.deepToString(data.toArray()));
    }
}
