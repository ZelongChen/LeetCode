package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

import java.util.HashSet;

/**
 * 160. Intersection of Two Linked Lists
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 如果可以用额外空间的话，那就用HashSet来存第一个链表的所有节点，然后遍历第二个链表，看HashSet里面有没有相同节点，有的话说明有交集，
     * 如果遍历完一遍都没有，那就是没有交集
     */
    public ListNode getIntersectionNodeWithHashSet(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 如果用两个指针 p1 和 p2 分别在两条链表上前进，并不能同时走到公共节点，也就无法得到相交节点 c1。
     *
     * 解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
     *
     * 所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
     *
     * 如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
     *
     * 那你可能会问，如果说两个链表没有相交点，是否能够正确的返回 null 呢？
     *
     * 这个逻辑可以覆盖这种情况的，相当于 c1 节点是 null 空指针嘛，可以正确返回 null。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }
}
