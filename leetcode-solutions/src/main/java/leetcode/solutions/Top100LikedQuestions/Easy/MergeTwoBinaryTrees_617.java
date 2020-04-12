package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import leetcode.solutions.Tools.TreeNode;

public class MergeTwoBinaryTrees_617 {
  
  //递归法
  public TreeNode solutionRecursive(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode node = new TreeNode(t1.val + t2.val);
    node.left = solutionRecursive(t1.left, t2.left);
    node.right = solutionRecursive(t1.right, t2.right);
    return node;
  }

  //能用递归解的就肯定能用循环解
  //利用stack来实现深度优先遍历
  public TreeNode solutionIterativeDFS(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }

    Stack<TreeNode[]> stack = new Stack<>();
    stack.push(new TreeNode[]{t1, t2});
    while(!stack.isEmpty()) {
      TreeNode[] t = stack.pop();
      if (t[0] == null || t[1] == null) {
        continue;
      }
      t[0].val += t[1].val;
      if (t[0].left == null) {
        t[0].left = t[1].left;
      } else {
        stack.push(new TreeNode[]{t[0].left, t[1].left});
      }
      if (t[0].right == null) {
        t[0].right = t[1].right;
      } else {
        stack.push(new TreeNode[]{t[0].right, t[1].right});
      }
    }
    return t1;
  }

  public TreeNode solutionIterativeBFS(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    Queue<TreeNode[]> queue = new LinkedList<>();
    queue.offer(new TreeNode[]{t1, t2});
    while(!queue.isEmpty()) {      
      TreeNode[] t = queue.poll();
      if (t[0] == null || t[1] == null) {
        continue;
      }
      t[0].val += t[1].val;
      if (t[0].left == null) {
        t[0].left = t[1].left;
      } else {
        queue.offer(new TreeNode[]{t[0].left, t[1].left});
      }
      if (t[0].right == null) {
        t[0].right = t[1].right;
      } else {
        queue.offer(new TreeNode[]{t[0].right, t[1].right});
      }
    }
    return t1;
  }
}