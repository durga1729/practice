package practice.dp;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
      ListNode l = new ListNode(1);
      l.next = new ListNode(3);
      l.next.next = new ListNode(4);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);

        ListNode node = mergeTwoSortedLists(l,l1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    //    System.out.println(node);
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
}
