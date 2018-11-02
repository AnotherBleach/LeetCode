package PartitionList;

import org.junit.Test;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //算法思想正确，但是没有必要重新创造节点用之前的就可以啊
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null)
            return head;


        ListNode small_head = null, small_tail = null;
        ListNode big_head = null, big_tail = null;
        while (head != null) {
            if (head.val < x) {
                if (small_head == null) {
                    small_head = small_tail =new ListNode(head.val);
                    small_head.next = small_tail.next = null;


                } else {

                    ListNode temp = head;
                    small_tail.next = temp;
                    temp.next = null;
                    small_tail = temp;

                }


            } else {

                if (big_head == null) {
                    big_head = big_tail = new ListNode(head.val);
                    big_head.next = big_tail.next = null;

                } else {
                    ListNode temp =head;
                    big_tail.next = temp;
                    temp.next = null;
                    big_tail = temp;


                }

            }
            head = head.next;

        }

        if(big_head == null)return small_head;
        if(small_head == null)return big_head;

        small_tail.next = big_head;
        big_tail.next = null;

        return small_head;

    }

    @Test
    public void test() {
        ListNode v1 = new ListNode(1);

        ListNode v2 = new ListNode(4);

        ListNode v3 = new ListNode(3);

        ListNode v4 = new ListNode(2);

        ListNode v5 = new ListNode(5);

        ListNode v6 = new ListNode(2);

        v1.next = v2;
        v2.next=v3;
        v3.next=v4;
        v4.next=v5;
        v5.next=v6;
        v6.next = null;
        ListNode now = partition(v1, 0);
        while (now != null) {
            if (now.next != null)
                System.out.print(now.val + "->");
            else
                System.out.println(now.val);
            now = now.next;
        }


    }


}
