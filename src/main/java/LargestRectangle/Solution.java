package LargestRectangle;

import org.junit.Test;

public class Solution {


    public int largestRectangleArea(int[] heights, int x) {

        int result = 0;

        for (int i = 0; i < heights.length; i++) {

            int current = heights[i];
            int currentMinimal = heights[i];
            for (int j = i + 1; j < heights.length; j++) {

                if (heights[j] >= currentMinimal)
                    current += currentMinimal;
                else {

                    int width = current/currentMinimal;
                   // System.out.println(heights[j]);

                    int nowArea = (width+1)*heights[j];
                    //System.out.println(nowArea);
                    if(nowArea>=current){current = nowArea;currentMinimal = heights[j];}
                    else break;
                }

            }

            if (current > result) result = current;


        }


        return result;

    }


    public int largestRectangleArea(int[] heights) {

        int[] arr = new int[heights.length];
        int[] zero = new int[heights.length];




        return getMaxAreaFromIndex(heights, 0, arr);
    }

    public int getMaxAreaFromIndex(int[] heights, int index, int[] mini) {
        int result = 0;
        if (heights.length <= 0) return 0;
        if (heights.length == 1 || index == heights.length - 1) {
            mini[index] = heights[index];
            return heights[index];
        }


        int maxSonArea = getMaxAreaFromIndex(heights, index + 1, mini);


        int minimalHeight = mini[index + 1];


        if (heights[index] >= minimalHeight) {

            if (minimalHeight == 0) {
                mini[index] = heights[index];
                result = heights[index];

            } else {
                result = maxSonArea + minimalHeight;
                mini[index] = minimalHeight;
            }
        } else {


            int width = maxSonArea / minimalHeight;
            int nowArea = (width + 1) * heights[index];
            int maxArea = Math.max(nowArea, maxSonArea);
            if (maxArea == nowArea) {
                //现在更加大
                mini[index] = heights[index];


            } else {
                mini[index] = minimalHeight;

            }
            result = maxArea;

        }


        return result;


    }

    @Test
    public void test() {

        System.out.println(largestRectangleArea(new int[]{2, 1,5,6,2,3}, 2));
        // System.out.println(largestRectangleArea(new int[]{9,0}));

    }


}


