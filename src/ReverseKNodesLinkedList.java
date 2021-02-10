public class ReverseKNodesLinkedList {

    public ListNode solve(ListNode A, int B) {
        ListNode prev = null,p =null,pp=null, curr = A, next = null, output=null;
        int i=0;
        while(curr!=null){
            pp = prev;
            p = curr;
            i=0;
            while(i++!=B){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(pp==null)
                output = prev;
            p.next = curr;
            if(pp!=null)
                pp.next = prev;
            i = 0;
            while(i++!=B && curr!=null){
                prev=curr;
                curr = curr.next;
            }
        }

        return output;
    }
}
