package MergeKSortedLists;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode Another = null;
        ListNode tail = null;
        ListNode[] pointer = new ListNode[lists.length];
        for (int i = 0; i < pointer.length; i++)
            pointer[i] = lists[i];
        int minnum = Integer.MAX_VALUE;
        int counter = lists.length;
        int index = 0;
        while (counter != 0) {
            for (int i = 0; i < lists.length; i++) {
                minnum = Integer.MAX_VALUE;
                index = 0;
                if (pointer[i] == null) continue;
                if (minnum > pointer[i].val) {
                    minnum = pointer[i].val;
                    index = i;
                }
            }
            if (Another == null) {

                Another = new ListNode(minnum);
                tail = Another;
                tail.next = null;
            } else {

                ListNode temp = new ListNode(counter);
                temp.next = null;
                tail.next = temp;
                tail = temp;
                pointer[index] = pointer[index].next;
                if (pointer[index] == null)
                    counter--;
            }

        }

        return Another;
    }

}
