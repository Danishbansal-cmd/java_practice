package leetcode;

import java.util.*;

class ListNode {
    char val;
    ListNode next;

    ListNode(char val) {
        this.val = val;
    }
}

public class Main {

    public static ListNode findCommonPart(ListNode head1, ListNode head2) {
        int l1 = 0, l2 = 0;

        ListNode dummy = new ListNode('0');

        ListNode head = head1;
        while(head != null){
            l1++;
            head = head.next;
        }

        head = head2;
        while(head != null){
            l2++;
            head = head.next;
        }

        int ml = 0;
        head = dummy;
        ListNode th1 = head1, th2 = head2;
        while(th1 != null && th2 != null && th1.val == th2.val){
            ListNode newNode = new ListNode(th1.val);
            head.next = newNode;
            head = head.next;

            ml++;
            th1 = th1.next;
            th2 = th2.next;
        }


        if(ml == 0){
            if(l1 > l2){
                return head1;
            }else if(l2 > l1){
                return head2;
            }
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode build(String s) {
        ListNode dummy = new ListNode('#');
        ListNode tail = dummy;

        for (char c : s.toCharArray()) {
            tail.next = new ListNode(c);
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head1 = build("abcdef");
        ListNode head2 = build("abcxyz");

        ListNode result = findCommonPart(head1, head2);

        print(result);
    }
}

