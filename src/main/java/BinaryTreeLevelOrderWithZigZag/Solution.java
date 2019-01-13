package BinaryTreeLevelOrderWithZigZag;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> odd = new Stack();//left->right
        Stack<TreeNode> even = new Stack<>();//right-left
        odd.add(root);
        boolean should_use_odd = true;
        List<Integer> temp = new ArrayList<>();
        while (!odd.isEmpty() || !even.isEmpty()) {

            if (should_use_odd) {

                TreeNode top = odd.pop();

                if (top.left != null) even.add(top.left);
                if (top.right != null) even.add(top.right);
                temp.add(top.val);
                if (odd.empty()) {
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                    should_use_odd = false;
                }


            } else {

                TreeNode top = even.pop();

                if (top.right != null) odd.add(top.right);
                if (top.left != null) odd.add(top.left);
                temp.add(top.val);
                if (even.empty()) {
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                    should_use_odd = true;
                }


            }


        }


        return result;
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(3);
        TreeNode leftchild = new TreeNode(9);
        TreeNode rightchild = new TreeNode(20);
        root.left = leftchild;
        root.right = rightchild;


        TreeNode ll = new TreeNode(4);
        TreeNode rr = new TreeNode(5);
        ll.left = ll.right = rr.left = rr.right = null;
        leftchild.left = ll;
        leftchild.right = rr;


        TreeNode l = new TreeNode(15);
        TreeNode r = new TreeNode(7);
        l.left = l.right = r.left = r.right = null;
        rightchild.left = l;
        rightchild.right = r;
        List list = zigzagLevelOrder(root);
        System.out.println(Arrays.deepToString(list.toArray()));
    }
}