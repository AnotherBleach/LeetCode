package reorder_list;

import org.junit.Test;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public void reorderList(ListNode head) {

        if(head == null||head.next == null)return;

        ArrayList<ListNode>nodes_list = new ArrayList<>();
        ListNode temp = head;
        while(null!=temp)
        {
            nodes_list.add(temp);
            temp = temp.next;

        }
        int size = nodes_list.size();
        ListNode pre = null;
        int i,j;
        for( i=0,j=size-1;i<j;i++,j--)
        {
            ListNode front= nodes_list.get(i);
            ListNode back = nodes_list.get(j);
            front.next = back;
            if(pre!=null)
            {
                pre.next = front;

            }
            pre=back;



        }
        if(i==j)
        {
            nodes_list.get(i).next = null;
            pre.next = nodes_list.get(i);

        }else{


            nodes_list.get(i).next = null;

        }





    }
    @Test
    public void test()
    {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
       // ListNode five = new ListNode(5);

        one.next = two;
        two.next=three;
        three.next =four;
        four.next=null;
       // five.next=null;
        reorderList(one);
        while(one!=null)
        {

            System.out.print(one.val+" ");
            one = one.next;

        }

    }

}
