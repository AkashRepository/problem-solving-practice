package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode stringToLinkedList(String str) {
        ListNode n = new ListNode(-1);
        ListNode t = n;
        String[] s = str.split(",");
        for (String ss : s) {
            n.next = new ListNode(Integer.parseInt(ss));
            n = n.next;
        }
        return t.next;
    }

    public static String linkedListToString(ListNode l) {
        String str = "";
        while (l != null) {
            str = str + "," + l.val;
            l = l.next;
        }
        return str;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}