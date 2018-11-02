package Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import org.junit.Test;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode head = null;
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        if (preorder.length == 1 || inorder.length == 1)
            return new TreeNode(preorder[0]);

        int root = preorder[0];
        head = new TreeNode(root);
        int root_pos_in_inorder = 0;
        for (; root_pos_in_inorder < inorder.length; root_pos_in_inorder++) {
            if (inorder[root_pos_in_inorder] == root)
                break;

        }

        int[] left_pre_child = Arrays.copyOfRange(preorder,1,root_pos_in_inorder+1);
        int[] left_in_child = Arrays.copyOfRange(inorder,0,root_pos_in_inorder);
        int[] right_pre_child = Arrays.copyOfRange(preorder,root_pos_in_inorder+1,preorder.length);
        int[] right_in_child = Arrays.copyOfRange(inorder,root_pos_in_inorder+1,inorder.length);

        TreeNode left_child = buildTree(left_pre_child, left_in_child);
        TreeNode right_child = buildTree(right_pre_child,right_in_child);

        head.left = left_child;
        head.right = right_child;
        return head;
    }

    public void travel(TreeNode node)
    {
        if(node!=null)
        {
            travel(node.left);
            travel(node.right);
            System.out.print(node.val+" ");


        }


    }
    @Test
    public void test() {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        travel(buildTree(pre,in));


    }

}
