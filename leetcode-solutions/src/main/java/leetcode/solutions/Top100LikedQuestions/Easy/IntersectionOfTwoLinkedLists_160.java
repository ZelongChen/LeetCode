package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.HashSet;
import java.util.Set;

import leetcode.solutions.Tools.ListNode;

public class IntersectionOfTwoLinkedLists_160 {

  /**
   * 如果可以用额外空间的话
   * 可以利用set来存第一个链表的每一个节点
   * 然后遍历第二个链表，如果能在set里找到相同节点，说明有交叉，返回这个交叉点
   * 如果遍历一遍都没有找到，说明没有交叉，返回null
   */
  public ListNode solutionWithSet(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    Set<ListNode> set = new HashSet<>();
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
   * 不用额外空间的方法 
   * 把问题分成两步首先先判断两个链表有没有交点，然后再找交点
   * 先遍历两个链表到达末尾节点，如果二者相同，说明有交点，不然说明没有交点
   * 第一遍遍历的同时，记录两个链表的长度
   * 接着让相对长的链表向前移动长度差个点，这样两个链表剩下的长度相同，交点肯定在这里面
   * 然后再同时遍历两个链表，比较每一个点，第一个相同的就是交点
   */
  public ListNode solutionWithCount(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int countA = 1;
    int countB = 1;
    ListNode nodeA = headA;
    ListNode nodeB = headB;

    while (nodeA.next != null) {
      countA++;
      nodeA = nodeA.next;
    }
    while (nodeB.next != null) {
      countB++;
      nodeB = nodeB.next;
    }
    if (nodeA != nodeB) {
      return null;
    }
    nodeA = headA;
    nodeB = headB;
    int diff = Math.abs(countA - countB);
    if (countA > countB) {
      for (int i = 0; i < diff; i++) {
        nodeA = nodeA.next;
      }
    }
    if (countB > countA) {
      for (int i = 0; i < diff; i++) {
        nodeB = nodeB.next;
      }
    }
    while (nodeA != null) {
      if (nodeA == nodeB) {
        return nodeA;
      }
      nodeA = nodeA.next;
      nodeB = nodeB.next;
    }
    return null;
  }

  //这个方法更神奇一点，不需要去记录两个链表的长度
  //同时遍历两个链表，当a走到底之后，转到b的头，重新开始，当b走到底之后，转到a的头，重新开始
  //其实这是利用len(a) > len(b)的时候，因为b比较短，所以b比a更快len(a) - len(b)步到达底
  //这样当a到达底的时候，b已经转到a的头，而且走了len(a) - len(b)步了
  //这样的结果是，a,b两个指针剩下的节点数是一样的了，同时遍历就能找到相同的节点
  //如果没有相交点，他们也会同时到达最终点，都是null
  public ListNode solutionWithoutCount(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode nodeA = headA;
    ListNode nodeB = headB;

    while (nodeA != nodeB) {
      nodeA = nodeA == null ? headB : nodeA.next;
      nodeB = nodeB == null ? headA : nodeB.next;
    }
    return nodeA;
  }
}