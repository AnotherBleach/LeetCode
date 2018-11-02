package Reverse_Linked_ListII;

import org.junit.Test;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //beats 100%
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //reverse list from m to n

        //special
        if (head == null || n <= m)
            return head;

        //normal
        int counter = 0;

        ListNode result = null;
        ListNode tailOfResult = null;
        ListNode headOfReverse = null;
        ListNode tailOfReverse = null;
        while (head != null && counter <= n) {

            counter++;
            if (counter < m) {
                if (result == null) {
                    result = head;
                    tailOfResult = head;
                } else {
                    tailOfResult = head;

                }
                head = head.next;

            } else if (counter < n) {

                if (counter == m) {
                    tailOfReverse = head;


                }
                ListNode temp = head.next;
                head.next = headOfReverse;
                headOfReverse = head;
                head = temp;


            } else if (counter == n) {

                if (tailOfResult == null) {

                        ListNode temp = head.next;
                        head.next = headOfReverse;
                        tailOfReverse.next=temp;
                        result = head;

                } else {

                    tailOfResult.next = head;
                    ListNode temp = head.next;
                    head.next = headOfReverse;

                    tailOfReverse.next = temp;
                }
                break;


            }

        }
        return result;

    }

    @Test
    public void test() {
        ListNode son1 = new ListNode(1);
        ListNode son2 = new ListNode(2);
        ListNode son3 = new ListNode(3);
        ListNode son4 = new ListNode(4);
        ListNode son5 = new ListNode(5);

        son1.next = son2;
        son2.next = son3;
        son3.next = son4;
        son4.next = son5;
        son5.next = null;

        ListNode lists = reverseBetween(son1, 1, 2);
        while (lists != null) {
            System.out.print(lists.val + " ");
            lists = lists.next;

        }

    }


}
