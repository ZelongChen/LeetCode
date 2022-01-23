package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * <p>
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    /**
     * 其实就是利用二进制转换为十进制的公式，当前值乘以2，然后一个一个往后算
     */
    public int getDecimalValue(ListNode head) {
        int value = 0;
        while (head != null) {
            value = value * 2 + head.val;
            head = head.next;
        }
        return value;
    }
}
