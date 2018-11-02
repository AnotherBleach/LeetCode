package SortList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null||head.next == null)
            return head;

        List<Integer>data = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            data.add(temp.val);
            temp = temp.next;

        }
        Collections.sort(data);
        Integer[]nums = new Integer[data.size()];
        data.toArray(nums);


        ListNode temp2 = head;
        int i=0;
        while(temp2!=null)
        {

            temp2.val = nums[i++];
            temp2 =  temp2.next;
        }

        return head;

    }

}
