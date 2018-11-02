package Convert_Sorted_Array_to_Binary_Search_Tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.Vector;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode sortedArrayToBST(Integer[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        TreeNode root = null;
        root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        Integer[] nums = covertToArray(head);
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        TreeNode root = null;
        root = new TreeNode(nums[nums.length / 2]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return root;
    }

    private Integer[] covertToArray(ListNode head) {
        Vector<Integer> temp = new Vector<>();
        while (head != null) {

            temp.add(head.val);
            head = head.next;

        }
        Integer[] result = new Integer[temp.size()];

        temp.toArray(result);
        return result;
    }

    @Test
    public void test() {
        travel(sortedArrayToBST(new Integer[]{-10, -3, 0, 5, 9}));

    }

    public void travel(TreeNode root) {
        if (root != null) {
            travel(root.left);
            System.out.print(root.val + " ");
            travel(root.right);


        }

    }

}
