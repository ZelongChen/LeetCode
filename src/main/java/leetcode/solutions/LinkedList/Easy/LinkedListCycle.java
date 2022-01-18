package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

/**
 * 141. Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
public class LinkedListCycle {
    /**
     * 设置fast和slow两个新指针，fast指针每次往后移动两位，slow指针每次往后移动一位，如果存在cycle，那么他们两个就会有重合的时候
     * 如果没有cycle，那fast指针就会先遍历完链表
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
