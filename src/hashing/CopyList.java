package hashing;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {

        RandomListNode n = head;
        RandomListNode temp = new RandomListNode(-1);
        RandomListNode out = temp;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (n != null) {
            temp.next = new RandomListNode(n.label);
            temp = temp.next;
            temp.random = n.random;
            map.put(n, temp);
            n = n.next;
        }
        temp = out.next;
        while (temp != null) {
            temp.random = map.get(temp.random);
            temp = temp.next;
        }
        return out.next;
    }
}
