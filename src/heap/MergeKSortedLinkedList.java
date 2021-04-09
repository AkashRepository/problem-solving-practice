package heap;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLinkedList {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> Integer.valueOf(a.val).compareTo(b.val));
        for(ListNode n : lists){
            ListNode t = n;
            while(t!=null){
                pq.offer(t);
                t = t.next;
            }
        }
        ListNode temp = new ListNode(-1);
        ListNode node = temp;
        while(!pq.isEmpty()){
            node.next = pq.poll();
            if(node.next!=null)
                node.next.next = null;
            node = node.next;
        }
        return temp.next;
    }
// divide and conquer

    private ListNode merge(ListNode a, ListNode b){
        ListNode out = new ListNode(-1);
        ListNode merged = out;
        ListNode aa = a;
        ListNode bb = b;
        while(aa!=null && bb!=null){
            if(aa.val <= bb.val){
                merged.next = aa;
                merged = merged.next;
                aa = aa.next;
            } else {
                merged.next = bb;
                merged = merged.next;
                bb = bb.next;
            }
        }
        if(aa!=null){
            merged.next = aa;
        } else {
            merged.next = bb;
        }
        // System.out.println(out.next.val);
        return out.next;
    }

    public ListNode mergeKListsDnC(ListNode[] lists) {
        int n = lists.length;
        if(n==0){
            return null;
        }
        int width=1;
        while(width<n){
            for(int i=0;(i+width)<n;i=i+width*2){
                // System.out.println("i:"+i);
                lists[i] = merge(lists[i], lists[i+width]);
            }
            width = width*2;
        }
        return lists[0];
    }
}
