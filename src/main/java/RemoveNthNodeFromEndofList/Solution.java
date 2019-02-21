package RemoveNthNodeFromEndofList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;
        ListNode pre, tail;
        pre = tail = head;

        while (n != 0)
        {
            tail = tail.next;
            n--;
            if(tail == null)return head.next;
        }
        while (tail.next != null) {
                tail = tail.next;
                pre = pre.next;

        }
        if(pre.next!=null)pre.next = pre.next.next;
        else pre.next = null;
        return head;

    }
}
