package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

/**
 * 20. Remove Linked List Elements
 * <p>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {
    /**
     *  把问题分成两步
     *  1. 如何删除节点
     *      a. 创建一个新节点node，起始指向head。从头开始遍历linked list
     *      b. 当node的下一个节点不是Null而且它的值等于val的时候，说明找到了，通过node.next = node.next.next，跳过这个节点来实现删除
     *      c. 当node的下一个节点是Null或者它的值不等于val的时候，说明不是，那就node = node.next来继续遍历
     *      d. 当node等于Null的时候，说明已经遍历完链表了，已经删除所有val节点
     *  2. 什么时候需要移动head
     *      a. 只有当步骤1里找到需要删除的节点正好是head节点的时候，需要通过head = head.next来改变head节点
     *
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        while (node != null) {
            if (node.next != null && node.next.val == val) {
                if (head == node.next) {
                    head = head.next;
                }
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
