package linkedlist;

import common.ListNode;

public class PartialReverseLinkedList {



    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null, curr = head, next = null, s = null;
        int c = 1;
        while (c != m + 1) {
            s = prev;
            prev = curr;
            curr = curr.next;
            if (curr != null)
                next = curr.next;
            c++;
        }

        while (c != n + 1) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        if (s != null && s.next != null)
            s.next.next = next;
        if (s != null && prev != null && prev.next != s)
            s.next = prev;

        return head;
    }

    public static void main(String[] args) {
        PartialReverseLinkedList o = new PartialReverseLinkedList();
        ListNode root = new ListNode(3, new ListNode(5, null));
        System.out.println(o.reverseBetween(root,1,2));
    }
}
