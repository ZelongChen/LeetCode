package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.Stack;

import leetcode.solutions.Tools.ListNode;

public class PalindromeLinkedList_234 {
  //如果可以用额外空间的话
  //利用stack，第一遍便利的时候把值都压进stack里
  //第二遍遍历的时候，就可以把值和stack里弹出的值比较
  public boolean solutionWithExtraMemory(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode node = head;
    while (node != null) {
      stack.push(node);
      node = node.next;
    }
    node = head;
    while (node != null) {
      ListNode pop = stack.pop();
      if (pop.val != node.val) {
        return false;
      }
      node = node.next;
    }
    return true;
  }

  //如果不能用额外空间的话
  //可以把链表从正中间分成两段，把后半段翻转，然后如果前后两段现在相同的话，说明原来是回文的
  public boolean solutionWithReverse(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    //长度为奇数，slow正好指向中间节点，跳过，从下半段开始
    if (fast != null) {
      slow = slow.next;
    }
    ListNode secondHead = reverse(slow);
    ListNode firstHead = head;
    while (secondHead != null) {
      if (firstHead.val != secondHead.val) {
        return false;
      }
      firstHead = firstHead.next;
      secondHead = secondHead.next;
    }
    return true;
  }

  private ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
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
}