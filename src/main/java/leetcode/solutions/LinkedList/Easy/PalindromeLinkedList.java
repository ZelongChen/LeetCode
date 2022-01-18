package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

import java.util.Stack;

/**
 * 234. Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class PalindromeLinkedList {
    /**
     *   如果可以用额外空间的话
     *   利用stack，第一遍便利的时候把值都压进stack里
     *   第二遍遍历的时候，就可以把值和stack里弹出的值比较
     */
    public boolean isPalindromeWithExtraMemory(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (pop.val != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
