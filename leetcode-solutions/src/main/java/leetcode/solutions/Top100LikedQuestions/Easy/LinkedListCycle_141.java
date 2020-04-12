package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.solutions.Tools.ListNode;

public class LinkedListCycle_141 {

  //链表的题型里挺经典的问题
  //通过快慢两个指针，一个移一步，一个移两步，正常的话二者不会有交集，但如果链表中存在cycle的话，二者就可能相交
  public boolean solutionWithDoublePointers1(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode p1 = head;
    ListNode p2 = head;

    while(p2 != null) {
      if (p2.next != null) {
        p1 = p1.next;
        p2 = p2.next.next;
        if (p1 == p2) {
          return true;
        }
      } else {
        return false;
      }
    }
    return false;
  }

  public boolean solutionWithDoublePointers2(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;

    while(slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  //遍历链表，用map来存储每个出现过节点
  //当map里存在一个节点和新节点相同，说明有cycle
  public boolean solutionWithMap1(ListNode head) {
    Map<ListNode, Integer> map = new HashMap<>();
    int index = 0;
    while(head != null) {
      if (map.containsKey(head)) {
        return true;
      }
      map.put(head, index++);
      head = head.next;
    }
    return false;
  }

  public boolean solutionWithMap2(ListNode head) {
    Map<ListNode, Integer> map = new HashMap<>();
    int index = 0;
    while(head != null) {
      if(map.put(head, index++) != null) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  //可以再简化一下，利用set的特性来完成这个判断
  public boolean solutionWithSet(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    while(head != null) {
      if (set.contains(head)) {
        return true;
      }
      set.add(head);
      head = head.next;
    }
    return false;
  }
}