package Binary_Tree_Level_Order_Traversal_II;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        int current_layer = 1;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        nodes.add(root);
        layers.add(1);
        List<Integer> temp = new ArrayList<>();
        while (!nodes.isEmpty()) {
            TreeNode top = nodes.poll();
            Integer layer = layers.poll();
            if (top.left != null) {
                nodes.add(top.left);
                layers.add(layer + 1);
            }
            if (top.right != null) {
                nodes.add(top.right);
                layers.add(layer + 1);
            }
            if (layer == current_layer)
                temp.add(top.val);
            else {
                current_layer++;
                if (result.size() != 0) result.add(0, temp);
                else result.add(temp);
                temp = new ArrayList<>();
                temp.add(top.val);
            }


        }
        if (temp.size() != 0) {

            if (result.size() != 0) result.add(0, temp);
            else result.add(temp);
        }
        return result;

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode root_left_child = new TreeNode(9);
        TreeNode root_right_child = new TreeNode(20);
        root.left = root_left_child;
        root.right = root_right_child;
        root_left_child.left = root_left_child.right = null;
        root_right_child.left = new TreeNode(15);
        root_right_child.right = new TreeNode(7);
        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(Arrays.deepToString(result.toArray()));
        //travel(root);


    }

    public void travel(TreeNode node) {
        if (node != null) {
            travel(node.left);
            travel(node.right);
            System.out.print(node.val + " ");


        }


    }


}
