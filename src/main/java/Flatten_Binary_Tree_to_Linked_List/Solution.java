package Flatten_Binary_Tree_to_Linked_List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {

        if(root!=null)
        {
            TreeNode left_child = root.left;
            TreeNode right_child = root.right;
            flatten(left_child);
            flatten(right_child);
            root.left = null;


           if(left_child!=null)
               root.right = left_child;
           else
               root.right = right_child;

            TreeNode tail = left_child;
            if(tail!=null) {
                while (tail.right != null)
                    tail = tail.right;
                tail.right = right_child;
            }



        }

    }

}
