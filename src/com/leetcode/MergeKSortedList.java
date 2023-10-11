package com.leetcode;

/**
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * Level: HARD
 * Concept: Merge Sort
 */
public class MergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = (end + start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);

        ListNode current = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                current.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        return result.next;
    }
}
