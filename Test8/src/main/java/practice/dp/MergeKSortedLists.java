package practice.dp;

public class MergeKSortedLists {
    public static void main(String[] args) {

    }

    public static AddTwoNumbers.ListNode mergeKlist(AddTwoNumbers.ListNode[] listNodes) {
        if (listNodes == null || listNodes.length == 0) return null;
        return mergeKLists(listNodes, 0, listNodes.length - 1);
    }

    private static AddTwoNumbers.ListNode mergeKLists(AddTwoNumbers.ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        AddTwoNumbers.ListNode left = mergeKLists(lists, start, mid);
        AddTwoNumbers.ListNode right = mergeKLists(lists, mid + 1, end);
        return merge(left, right);
    }

    private static AddTwoNumbers.ListNode merge(AddTwoNumbers.ListNode l1, AddTwoNumbers.ListNode l2) {
        AddTwoNumbers.ListNode result = new AddTwoNumbers.ListNode(-1);
        AddTwoNumbers.ListNode curr = result;
        while (l1 == null || l2 == null) {
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
        return result.next;
    }

}
