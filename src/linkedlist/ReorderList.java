package linkedlist;

import common.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        ReorderList o = new ReorderList();
        ListNode l = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
//        ListNode l5 = new ListNode(5);
//        l4.next = l5;
        System.out.println(o.reorderList(l));
    }

    public ListNode reorderList(ListNode A) {
        ListNode fast = A, slow = A, slower = null;
        while (fast != null && fast.next != null) {
            slower = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null, curr = slow, next = null;
        if (slower != null)
            slower.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = A;
        fast = null;
        slow = null;
        while (curr != null && prev != null) {
            fast = curr.next;
            curr.next = prev;
            slow = prev.next;
            prev.next = fast;
            curr = fast;
            slower = prev;
            prev = slow;
        }
        if(prev!=null)
            slower.next = prev;
        return A;
    }
}
