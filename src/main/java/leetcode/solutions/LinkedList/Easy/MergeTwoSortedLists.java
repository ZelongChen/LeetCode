package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

/**
 *  21. Merge Two Sorted Lists
 *
 *  You are given the heads of two sorted linked lists list1 and list2.
 *
 *  Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 *  Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个虚拟头结点，指向头结点，用来最后的返回
        ListNode head = new ListNode(-1);
        // 创建一个当前节点，用来充当拉链法中的那个拉链
        ListNode current = head;
        // 当两个链表都还没遍历到头的时候，才对两个链表进行比较
        while (list1 != null && list2 != null) {
            // 判断两个链表当前值的大小，让current节点指向值小的节点
            // 然后将current节点和被选中的节点都向后移动一位，进行下一次比较
            if (list1.val > list2.val) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
        }
        // 将剩下的节点接到current节点后面
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return head.next;
    }
}
