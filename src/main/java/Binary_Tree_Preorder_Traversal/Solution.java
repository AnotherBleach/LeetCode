package Binary_Tree_Preorder_Traversal;

import java.util.*;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<Integer>result = new ArrayList<>();
    //LevelOrder
    public List<Integer> preorderTraversal(TreeNode root) {
        //use stack to simulate

        if (root == null)
            return result;

        Stack<TreeNode>left_stack = new Stack<>();
        Stack<TreeNode>right_stack = new Stack<>();
        left_stack.add(root);
        while(left_stack.size()!=0||right_stack.size()!=0)
        {
            if(left_stack.size()!=0)
            {

                TreeNode now = left_stack.pop();
                result.add(now.val);
                if(now.left!=null)
                    left_stack.add(now.left);
                if(now.right!=null)
                    right_stack.add(now.right);


            }else{
                TreeNode now = right_stack.pop();
                result.add(now.val);
                if(now.left!=null)
                    left_stack.add(now.left);
                if(now.right!=null)
                    right_stack.add(now.right);


            }



        }
        return result;

    }

}
