package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

import java.util.Stack;

/**
 * 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    /**
     * 利用stack先进后出的特性，遍历一遍list，把每个node存到stack里，然后再一个一个pop出来，实现reverse
     */
    public ListNode reverseListWithStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode node = new ListNode(-1);
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (head == null) {
                head = pop;
            }
            node.next = pop;
            node = node.next;
        }
        node.next = null;
        return head;
    }

    /**
     * 可以更简化，只需要循环一次
     * 用两个变量存下每一步prev和next，然后在循环的时候调换当前node的prev和next
     * prev每次都指向已经完成reverse的头部节点
     * head指向剩下还没有reverse的头部节点
     * next是一个临时变量，保存head.next节点
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
