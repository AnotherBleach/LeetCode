package Minimum_Depth_of_Binary_Tree;

import BitMapSort.Main;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int minDepth(TreeNode root) {

        if (root != null) {
            int left_depth = minDepth(root.left);
            int right_depth = minDepth(root.right);
            if (left_depth == 0 || right_depth == 0) {
                if (left_depth == 0) return right_depth + 1;
                return left_depth + 1;

            }
            return Math.min(left_depth, right_depth);


        }
        return 0;

    }

}
