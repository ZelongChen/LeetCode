package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

public class MiddleOfTheLinkedList {
    /**
     *  我们让两个指针 slow 和 fast 分别指向链表头结点 head
     *  每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点
     *  需要注意的是，如果链表长度为偶数，也就是说中点有两个的时候，我们这个解法返回的节点是靠后的那个节点。
     */
    public ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            fast = fast.next.next;
            slow = slow.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
