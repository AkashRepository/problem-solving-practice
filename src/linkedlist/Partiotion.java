package linkedlist;

import common.ListNode;

import java.util.List;

public class Partiotion {
    public static void main(String[] args) {
        Partiotion o = new Partiotion();
//        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
//        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(2);
        c.next = d;
        ListNode e = new ListNode(5);
        d.next = e;
        ListNode f = new ListNode(2);
        e.next = f;
        o.partition(b, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode prev = null;
        ListNode t = null;
        ListNode start = head;
        ListNode end = head;
        int count  = 0;
        while(end.next!=null){
            end = end.next;
        }
        while(start!=null){
            if(t!=null && start==t)
                break;
            if(start.val>=x && prev!=null){
                prev.next = start.next;
                start.next = null;
                end.next = start;
                end = end.next;
                if(t==null)
                    t = start;
                start = prev.next;
            } else if(start.val>=x) {
                ListNode temp = start.next;
                end.next = start;
                end = end.next;
                start.next = null;
                t = start;
                start = temp;
                head = start;
            } else{
                prev = start;
                start = start.next;}
        }
        return head;
    }
}
