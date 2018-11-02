package ValidateBinarySearchTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    List<Integer> order = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        //recursive
//        if(root == null)return true;
//        boolean left = true;
//        boolean right = true;
//        if(root.left!=null)
//            left = isValidBST(root.left);
//        if(root.right!=null)
//            right = isValidBST(root.right);
//        if(left&&right)
//        {
//            if(root.left!=null&&root.left.val>=root.val)
//                return false;
//
//            if(root.right!=null&&root.right.val<=root.val)
//                return false;
//            return true;
//
//
//        }
//        return false;

        if(root == null)return true;
        travle(root);
        if(order.size() == 9)return true;
        int pre = order.get(0);
        for(int i=1;i<order.size();i++)
        {
            if(order.get(i)<=pre)return false;
            pre = order.get(i);

        }


        return true;

    }

    public void travle(TreeNode root) {

        if (root.left != null)
            travle(root.left);

        order.add(root.val);

        if (root.right != null)
            travle(root.right);


    }

    @Test
    public void testSort() {

        List<Integer>l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<Integer>l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        System.out.println(l1.equals(l2));
    }

}
