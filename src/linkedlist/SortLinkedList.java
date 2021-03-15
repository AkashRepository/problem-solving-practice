package linkedlist;

import common.ListNode;

public class SortLinkedList {

    public static ListNode stringToLinkedList(String str){
        ListNode n = new ListNode(-1);
        ListNode t = n;
        String[] s = str.split(",");
        for (String ss : s){
            n.next = new ListNode(Integer.parseInt(ss));
            n = n.next;
        }
        return t.next;
    }

    public static String linkedListToString(ListNode l){
        String str = "";
        while(l!=null){
            str = str +","+ l.val;
            l = l.next;
        }
        return str;
    }

    public static void main(String[] args) {
        ListNode n = stringToLinkedList("-1,5,3,4,0");
        System.out.println(linkedListToString(new SortLinkedList().sortList(n)));
    }

    public ListNode sortList(ListNode head) {
        if(head==null)
            return null;
        return dnc(head);
    }

    private ListNode dnc(ListNode n){
        if(n==null)
            return n;
        if(n.next==null)
            return n;
        ListNode fast = n, slow=n, slow2 = null;
        while(fast!=null && fast.next!=null){
            slow2 = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        slow2.next = null;
        slow = n;
        ListNode f2 = dnc(fast);
        ListNode f3 = dnc(slow);
        ListNode r = mergeSort(f2, f3);
        return r;
    }

    private ListNode mergeSort(ListNode a, ListNode b){
        ListNode aa = a, bb = b;
        ListNode r = new ListNode(-1);
        ListNode t = r;
        while(aa!=null && bb!=null){
            if(aa.val < bb.val){
                r.next = aa;
                aa = aa.next;
            } else {
                r.next = bb;
                bb = bb.next;
            }
            r = r.next;
        }
        while(aa!=null){
            r.next = aa;
            aa = aa.next;
            r = r.next;
        }
        while(bb!=null){
            r.next = bb;
            bb = bb.next;
            r = r.next;
        }
        return t.next;
    }
}
