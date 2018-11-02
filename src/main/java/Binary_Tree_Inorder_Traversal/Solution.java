package Binary_Tree_Inorder_Traversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        InOrderTravel(root, result);
        return result;
    }

    public void InOrderTravel(TreeNode root, List<Integer> result) {
        if (root != null) {
            InOrderTravel(root.left, result);
            result.add(root.val);
            InOrderTravel(root.right, result);


        }


    }

    @Test
    public void test() {



    }

}
