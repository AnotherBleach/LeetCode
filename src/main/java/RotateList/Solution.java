package RotateList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode findPreNode(ListNode head, ListNode target) {

        if (head == target) return null;
        while (head != null && head.next != target)
            head = head.next;
        if (head != null && head.next == target)
            return head;
        return null;


    }

    //暴力移动，超时,优化次数过后AC。
    public ListNode rotateRight(ListNode head, int k) {
        int length = 1;
        if (head == null) return null;
        if (k == 0 || head.next == null) return head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {

            tail = tail.next;
            length++;
        }
        System.out.println(length);
        k = k % length;


        while (k-- != 0) {

            ListNode pre = findPreNode(head, tail);
            pre.next = null;
            tail.next = head;
            head = tail;
            tail = pre;

        }
        return head;
    }

    //数学计算
    public ListNode rotateRight2(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode tail = head;
        int length = 0;
        while (temp != null) {
            if(temp.next==null)
                tail = temp;
            temp = temp.next;
            length++;


        }//计算长度
        k = k % length;
        if(k==0)return head;
        ListNode oldHead=head;
        ListNode newTail=null;
        int times = length-k-1;
        while(times--!=0) {

            head = head.next;
        }//定位到前面一个
        newTail = head;
        head=head.next;
        newTail.next =null;
        tail.next = oldHead;

        return head;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");

            head = head.next;

        }
        System.out.println();

    }

    @Test
    public void testRotate() {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        rotateRight2(n1, 1);

    }

    @Test
    public void test() {

        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        ListNode h1 = rotateRight2(n1, 1);
        print(h1);
        ListNode h2 = rotateRight2(h1, 1);
        print(h2);
        ListNode h3 = rotateRight2(h2, 1);
        print(h3);
        ListNode h4 = rotateRight2(h3, 1);
        print(h4);


    }

}
