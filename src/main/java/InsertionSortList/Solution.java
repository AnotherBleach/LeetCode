package InsertionSortList;

import org.junit.Test;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {// 还有元素未参与排序

            ListNode nextHead = head.next;

            if (newHead == null) {
                newHead = head;
                newHead.next = null;
            } else {

                ListNode pointer = newHead;
                ListNode pre_pointer = null;
                while (pointer != null) {
                    if (pointer.val < head.val) {
                        pre_pointer = pointer;
                        pointer = pointer.next;


                    } else break;


                }
                if (pre_pointer == null) {
                    head.next = newHead;
                    newHead = head;

                } else {
                    head.next = pre_pointer.next;
                    pre_pointer.next = head;
                }

            }

            head = nextHead;

        }

        return newHead;
    }

    @Test
    public void test() {

        ListNode head = new ListNode(3);
        ListNode tail1 = new ListNode(2);
        ListNode tail2 = new ListNode(1);
        ListNode tail3 = new ListNode(4);
        head.next = tail1;
        tail1.next = tail2;
        tail2.next = tail3;
        tail3.next = null;

        showList(insertionSortList(head));

    }

    public void showList(ListNode node) {
        while (node != null) {

            System.out.print(node.val + " ");
            node = node.next;


        }


    }
}
