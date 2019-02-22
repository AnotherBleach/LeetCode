package Reverse_Nodes_in_k_Group;

import org.junit.Test;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1||head==null)return head;
        ListNode root = null, slow = null, fast = null;
        slow = fast = head;
        for (int i = 1; i < k; i++) {

            if (fast.next != null)
                fast = fast.next;
            else {
                return reverseNode(head, fast);
            }

        }
        //  1    -> 2  ->  3  -> 4  ->  5
        //slow           fast
        //  1    <- 2  <-  3     4  ->  5

        ListNode next = fast.next;
        root = reverseNode(slow, fast);
        ListNode pre =  slow;


        while (next!=null&&fast != null) {


            slow = next;

            fast = slow;
            for (int i = 1; i < k; i++) {
                fast = fast.next;
                if (fast == null) break;

            }
            if (fast != null) {

                next = fast.next;
                ListNode temp = reverseNode(slow, fast);
                pre.next = temp;
                pre=slow;
                slow = next;


            } else {

                pre.next = next;

            }

        }


        return root;
    }

    public ListNode reverseNode(ListNode head, ListNode tail) {

        //---------------------//
        tail.next = null;
        if (tail == null || head == null||head==tail) return head;
        if (head.next == tail) {
            tail.next = head;
            head.next = null;
            return tail;
        }

        ListNode left = head, right = left.next, next = right.next;
        left.next = null;
        while (next != null) {

            right.next = left;
            left = right;
            right = next;
            next = next.next;

        }
        right.next = left;
        return right;

        //---------------------//

    }

    @Test
    public void test() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next= null;
        ListNode f = reverseKGroup(e,2);
        while (f != null) {

            System.out.println(f.val);
            f = f.next;
        }
    }
}
