package linkedlist;

import common.ListNode;

public class InsertionSortLinkedList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.stringToLinkedList("5,3,6,8,1,2");

        InsertionSortLinkedList o = new InsertionSortLinkedList();
        ListNode output = o.insertionSortList(listNode);
        System.out.println(ListNode.linkedListToString(output));
    }

    public ListNode insertionSortList(ListNode A) {
        ListNode prev = A;
        ListNode i = A.next;
        prev.next = null;
        ListNode temp = null;

        while (i != null) {

            temp = i.next;
            i.next = prev;
            ListNode j = prev;
            ListNode prevj = null;
            while (j != null) {
                if (j.val < i.val) {
                    if (prevj != null) {
                        prevj.next = i;
                        i.next = j;
                    } else {
                        prev = i;
                    }
                    break;
                }
                prevj = j;
                j = j.next;
            }
            if (j == null) {
                prevj.next = i;
                i.next = j;
            }
            i = temp;
        }

        temp = null;
        ListNode next = null;
        while (prev != null) {
            next = prev.next;
            prev.next = temp;
            A = prev;
            temp = prev;
            prev = next;
        }
        return A;
    }
}
