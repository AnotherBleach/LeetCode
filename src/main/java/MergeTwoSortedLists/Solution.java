package MergeTwoSortedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode Another = null;
        ListNode tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (Another == null) {

                    Another = new ListNode(l1.val);
                    tail = Another;
                    tail.next = null;


                } else {
                    ListNode temp = new ListNode(l1.val);
                    temp.next = null;
                    tail.next = temp;
                    tail = temp;


                }
                l1 = l1.next;
            } else {

                if (Another == null) {

                    Another = new ListNode(l2.val);
                    tail = Another;
                    tail.next = null;


                } else {
                    ListNode temp = new ListNode(l2.val);
                    temp.next = null;
                    tail.next = temp;
                    tail = temp;


                }

                l2 = l2.next;
            }


        }
        while(l1!=null)
        {
            ListNode temp = new ListNode(l1.val);
            temp.next = null;
            tail.next = temp;
            tail = temp;
            l1 = l1.next;


        }

        while(l2!=null)
        {
            ListNode temp = new ListNode(l2.val);
            temp.next = null;
            tail.next = temp;
            tail = temp;
            l2 = l2.next;


        }

    return Another;
    }
}
