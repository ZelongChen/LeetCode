package leetcode.solutions.Top100LikedQuestions.Easy;

import leetcode.solutions.Tools.ListNode;

public class MergeTwoSortedLists_21 {

    //要考虑边际情况，当其中一个list为空的时候，直接返回另一个就行
    //创建两个节点，一个头节点，指向第一个点，一个当前节点，永远指向最后一个点
    //遍历两个链表，当前节点指向数值小的那个，然后当前节点向后移，保持在最后一个点
    //当其中一个链表到底了，把当前节点指向下一个链表就完成了合并
    //返回头节点的下一个点
    public ListNode solutionWithIterative(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head.next;
    }
    //要考虑边际情况，当其中一个list为空的时候，直接返回另一个就行
    //判断两个链表的当前值，取值小的链表的当前节点，对它的下一个节点和另一个链表进行递归
    //返回取值小的链表的当前节点
    public ListNode solutionWithRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = solutionWithRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = solutionWithRecursive(l1, l2.next);
            return l2;
        }
    }
}