package Remove_Duplicates_from_Sorted_List_II;

import org.junit.Test;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head;
        int forbidden = head.val;
        ListNode next = head.next;
        //find newHead;
        while (next.val == forbidden) {

            next = next.next;
            if (next == null)
                return null;

        }
        newHead = next;
        ListNode tail = next;
        next = next.next;

        while (next!=null)
        {



        }



        return newHead;
    }

    @Test
    public void test() {
//        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(1);
//        ListNode a3 = new ListNode(1);
//        ListNode b1 = new ListNode(2);
//        ListNode b2 = new ListNode(3);
//
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = b1;
//        b1.next = b2;
//        b2.next=null;
//        ListNode now =deleteDuplicates(a1);
//        System.out.println(now.val);


    }


}
