package Balanced_Binary_Tree;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * only determine the height
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {


    public boolean isBalanced(TreeNode root) {

        if (root != null) {
            int left_height = calc(root.left);
            int right_height = calc(root.right);
            int factor = left_height - right_height;

            if ((factor == 0 || factor == 1 || factor == -1) && isBalanced(root.left) && isBalanced(root.right))
                return true;
            return false;


        }
        return true;

    }

    private int calc(TreeNode root) {

        if (root != null) {
            return Math.max(calc(root.left), calc(root.right)) + 1;

        }
        return 0;

    }

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode left_2 = new TreeNode(2);
        TreeNode left_3 = new TreeNode(3);
        TreeNode left_4 = new TreeNode(4);

        TreeNode right_2 = new TreeNode(2);
        TreeNode right_3 = new TreeNode(3);
        TreeNode right_4 = new TreeNode(4);

        one.left = left_2;
        one.right = right_2;

        left_2.left = left_3;
        left_2.right = null;

        left_3.left = left_4;
        left_3.right=null;

        left_4.left = left_4.right = null;

        right_2.left = null;
        right_2.right = right_3;
        right_3.right = right_4;
        right_3.left=null;
        right_4.left = right_4.right = null;

        System.out.println(isBalanced(one));


    }
}
