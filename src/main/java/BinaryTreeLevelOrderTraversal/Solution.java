package BinaryTreeLevelOrderTraversal;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> level = new LinkedList<>();


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        level.add(1);
        List<Integer> me = new ArrayList<>();
        int preLevel = 1;
        while (!queue.isEmpty()) {

            TreeNode now = queue.poll();
            Integer layer = level.poll();
            if (now.left != null) {
                queue.add(now.left);
                level.add(layer + 1);
            }
            if (now.right != null) {
                queue.add(now.right);
                level.add(layer + 1);

            }



                if (layer == preLevel) {
                    me.add(now.val);

                } else {

                    result.add(me);
                    preLevel=layer;
                    me = new ArrayList<>();
                    me.add(now.val);
                }
            }

        if(me.size()!=0)
            result.add(me);
        return result;


    }

    @Test
    public void test()
    {
        TreeNode head = new TreeNode(3);

        TreeNode b = new TreeNode(9);
        TreeNode b1 = new TreeNode(10);
        TreeNode b2 = new TreeNode(11);


        TreeNode c = new TreeNode(20);

        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        head.left = b;
        head.right =c;
        b.left = b1;
        b.right=b2;

        b1.left = b1.right = null;
        b2.left = b2.right = null;
        c.left  = d;
        c.right = e;

        d.left = d.right = e.left = e.right = null;

        List<List<Integer>> result = levelOrder(head);
        System.out.println(Arrays.deepToString(result.toArray()));

    }
}
