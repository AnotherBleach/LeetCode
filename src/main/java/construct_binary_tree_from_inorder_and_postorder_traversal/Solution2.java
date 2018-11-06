package construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.Arrays;

public class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0)
            return null;

        return buildTree(inorder, postorder, 0, inorder.length-1 , 0, postorder.length -1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inorder_begin, int inorder_end, int postorder_begin, int postorder_end) {

        if (postorder_begin >= postorder_end|| inorder_begin >= inorder_end) {
            TreeNode root = new TreeNode(postorder[postorder_begin]);
            root.left = root.right = null;
            return root;

        }

        TreeNode root = new TreeNode(postorder[postorder_end]);

        int left_size = inorder_begin;
        for (; inorder[left_size] != root.val; left_size++) ;
        root.left = buildTree(inorder, postorder, inorder_begin, left_size - 1, postorder_begin, left_size - 1);
        root.right=buildTree(inorder,postorder,left_size+1,inorder_end,left_size,postorder_end-1);

        return root;
    }

}
