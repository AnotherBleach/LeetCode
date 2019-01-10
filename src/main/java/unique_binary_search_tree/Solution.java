package unique_binary_search_tree;

import java.util.ArrayList;
import java.util.List;


//
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        if (n == 1) {
            List result = new ArrayList<>();
            result.add(new TreeNode(1));
            return result;
        }


        return generateTrees_withIndex(1, n);
    }

    public List<TreeNode> generateTrees_withIndex(int start, int end) {

        List<TreeNode> results = new ArrayList<>();
        if (start > end) {
            results.add(null);
            return results;

        }
        for (int i = start; i <= end; i++) {

            List<TreeNode> left_trees = generateTrees_withIndex(start, i - 1);

            List<TreeNode> right_trees = generateTrees_withIndex(i + 1, end);
            for (TreeNode left : left_trees) {
                for (TreeNode right : right_trees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    results.add(root);

                }


            }


        }

        return results;

    }
}
