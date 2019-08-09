package minNumberInRotateArray;

import org.junit.Test;

public class Solution {

    // 可能存在重复的数据，逆转数组
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;

        int left = 0, right = array.length - 1, mid = 0;
        while (array[left] >= array[right]) {

            mid = (left + right) / 2;

            if (right - left == 1) return array[right];
            if (array[mid] == array[left] && array[mid] == array[right])//三者相等。
            {
                int minnum = array[left];
                for (int i = left + 1; i <= right; i++) {

                    if (minnum > array[i]) minnum = array[i];

                }
                return minnum;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }

        }

        return array[mid];

    }

    @Test
    public void test() {
        System.out.println(minNumberInRotateArray(new int[]{6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335}));

    }

}