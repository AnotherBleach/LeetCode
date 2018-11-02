package construct_binary_tree_from_inorder_and_postorder_traversal;

import org.junit.Test;

import java.util.Arrays;

//accepted，but very slow
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        if (postorder.length == 1) {

            TreeNode root = new TreeNode(postorder[0]);
            root.left = root.right = null;
            return root;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        //find inorder
        int left_size = 0;
        for (; inorder[left_size] != root.val; left_size++) ;
        int[] left_inorder = Arrays.copyOfRange(inorder, 0, left_size);
        int[] left_postorder = Arrays.copyOfRange(postorder, 0, left_size);
        root.left = buildTree(left_inorder, left_postorder);

        int[]right_inorder = Arrays.copyOfRange(inorder,left_size+1,inorder.length);
        int[]right_postorder = Arrays.copyOfRange(postorder,left_size,postorder.length-1);
        root.right=buildTree(right_inorder,right_postorder);


        return root;
    }


    public void preTravel(TreeNode root)
    {
        if(root!=null)
        {
            System.out.print(root.val+" ");
            preTravel(root.left);
            preTravel(root.right);
        }

    }
    @Test
    public void test()
    {

    }
}
