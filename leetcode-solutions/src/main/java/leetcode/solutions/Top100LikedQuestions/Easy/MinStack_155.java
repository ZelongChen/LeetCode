package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.Stack;

public class MinStack_155 {
  
  //这题的麻烦点在于如何记录min的值，因为如果只记录一个，当这个min值被pop之后，如何能更新min的值
  //利用一个stack的方法
  //这个解法最精妙的地方在于，当push的时候，如果新进来的值小于等于当前最小值，那把原来的min也先push进来，然后替换成新的值
  //这样做的好处是，当pop的时候，如果pop出来的值是当前最小值，那说明，stack里的下一个值就是之前的最小值
  //这样保证永远存着之前一个最小值，可以以O(1)的时间进行读取
  static class MinStackWithOneStack {
    
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
      if (x <= min) {
        stack.push(min);
        min = x;
      }
      stack.push(x);
    }
    
    public void pop() {
      if (stack.pop() == min) {
        min = stack.pop();
      }
    }
    
    public int top() {
      return stack.peek();
    }
    
    public int getMin() {
      return min;
    }
  }

  //利用链表节点
  //其实思路和上面一样，就是，对于每一个新加入的点，除了自己本身的值，还存到当前为止的最小值
  //这样无论怎么pop,剩下的每个节点都存着当前的最小值，可以以O(1)的时间读取最小值
  class MinStackWithLinkedListNode {

    private Node node = null;
    public void push(int x) {
      if (node == null) {
        node = new Node(x, x, null);
      } else {
        node = new Node(x, Math.min(x, node.min), node);
      }
    }
    
    public void pop() {
      node = node.next;
    }
    
    public int top() {
      return node.val;
    }
    
    public int getMin() {
      return node.min;
    }
  }

  class Node {
    int val;
    int min;
    Node next;
    public Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }
}