package Convert_Sorted_List_to_Binary_Search_Tree;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null||head.next == null)
            return new TreeNode(head.val);

        TreeNode root = null;
        ListNode fast = null,slow = null;
        ListNode prev = null;
        fast = head;
        slow = head;
        // 奇数个 最后一个 fast.next == null
        // 偶数个 倒数第二个 fast = null
        while(fast!=null&&fast.next!=null)
        {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev.next = null;
        root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);


        return root;

    }
}
