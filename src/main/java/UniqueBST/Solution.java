package UniqueBST;

import org.junit.Test;

public class Solution {
    //recursive version
    public int numTrees(int n) {
        if (n <= 1) return n;
        int result = 0;
        for (int i = 1; i <= n; i++) {

            int left = buildTree(1, i - 1);
            int right = buildTree(i + 1, n);
            if(left==0||right==0)result = result+left+right;
            else result = result+left*right;


        }
        return result;
    }

    public int buildTree(int from, int to) {

        if (from > to) return 0;
        if (from == to) return 1;
        if (from + 1 == to) return 2;
        int result = 0;
        for (int i = from; i <= to; i++) {
            int left = buildTree(from, i - 1);
            int right = buildTree(i + 1, to);
            if (left == 0 | right == 0) result = result + left + right;
            else result = result + left * right;

        }

        return result;
    }

    @Test
    public void test() {

        System.out.println(numTrees(5));

    }
}
