package linkedlist;

import common.ListNode;

public class ReverseKNodesLinkedList {

    private int count(ListNode node){
        ListNode temp = node;
        int c = 0;
        while(temp!=null){
            temp = temp.next;
            c++;
        }
        return c;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, initialCurrent = null, previousInitialCurrent = null, curr = head, next = null, output = null;
        int i=0;

        int count = count(head);
        count = count/k;

        while(count-->0){
            previousInitialCurrent = initialCurrent;
            initialCurrent = curr;
            i = 0;
            while(i++!=k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(previousInitialCurrent == null)
                output = prev;
            if(initialCurrent != null)
                initialCurrent.next = curr;
            if(previousInitialCurrent != null)
                previousInitialCurrent.next = prev;
        }

        return output;
    }
}
