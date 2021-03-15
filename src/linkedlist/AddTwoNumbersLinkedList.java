package linkedlist;

import common.ListNode;

public class AddTwoNumbersLinkedList {

    public static ListNode stringToListNode(String str) {
        String[] strs = str.split(",");
        ListNode res = new ListNode(-1);
        ListNode output = res;
        for (String s : strs) {
            res.next = new ListNode(Integer.parseInt(s));
            res = res.next;
        }
        return output.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersLinkedList o = new AddTwoNumbersLinkedList();
        o.addTwoNumbers(stringToListNode("7,2,4,3"), stringToListNode("5,6,4"));
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    private int count(ListNode node) {
        int c = 0;
        while (node != null) {
            node = node.next;
            c++;
        }
        return c;
    }

    private void sum(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;

        ListNode last = null;
        int carry = 0;
        while (i != null && j != null) {
            int sum = i.val + j.val + carry;
            i.val = sum % 10;
            carry = sum / 10;
            last = i;
            i = i.next;
            j = j.next;
        }
        while (i != null) {
            int sum = i.val + carry;
            i.val = sum % 10;
            carry = sum / 10;
            last = i;
            i = i.next;
        }
        if (carry != 0) {
            last.next = new ListNode(carry);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int a = count(l1);
        int b = count(l2);
        if (a > b) {
            sum(l1, l2);

            return reverse(l1);
        }
        sum(l2, l1);
        return reverse(l2);
    }
}
