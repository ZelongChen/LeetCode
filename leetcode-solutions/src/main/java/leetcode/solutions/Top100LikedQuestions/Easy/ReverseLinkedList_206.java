package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.Stack;

import leetcode.solutions.Tools.ListNode;

public class ReverseLinkedList_206 {

  public ListNode solutionIterativeWithStack(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    Stack<ListNode> stack = new Stack<>();
    stack.push(head);
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    ListNode current = null;
    while (!stack.isEmpty()) {
      ListNode node = stack.pop();
      if (head == null) {
        head = node;
        current = node;
      }
      current.next = node;
      current = current.next;
    }
    current.next = null;
    return head;
  }

  //可以更简化，只需要循环一次
  //用两个变量存下每一步prev和next，然后在循环的时候调换当前node的prev和next
  public ListNode solutionIterative(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
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

  public ListNode solutionRecursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //假设head.next及后面的都是已经reverse好了的
    //这个node其实是最终结果的新头节点
    ListNode node = solutionRecursive(head.next);
    //将原本下一个节点的下一个指向当前节点，实现反转
    head.next.next = head;
    //将当前节点的下一个指向null
    head.next = null;
    return node;
  }
}