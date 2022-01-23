package leetcode.solutions.LinkedList.Easy;

import leetcode.solutions.Tools.ListNode;

/**
 * 237. Delete Node in a Linked List
 *
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 *
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class DeleteNodeInALinkedList {

    /**
     * 因为给的是要删除的节点，所以没法从头遍历来跳过要删除的节点
     * 所以我们只能把链表后面的节点一个一个往前移动，移动的不是节点，移动的是值
     * 等到倒数第二个节点，把最后一个节点的值复制以后，那最后一个节点就是多余的了，跳过，直接指向null，就完成了删除
     */
    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }
}
