package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import leetcode.solutions.Tools.TreeNode;

public class MaximumDepthOfBinaryTree_104 {
  //递归法
  //每一层都分别计算左右节点的深度，然后返回取其大者加上自身这层的1
  //注意边际情况，叶子节点说明是最后一层，返回1，如果节点为空，返回0
  public int solutionWithRecursive(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      return 1;
    }
    return 1 + Math.max(solutionWithRecursive(root.left), solutionWithRecursive(root.right));
  }
  //递归法更简化版本
  //无需去判断叶子节点，继续向下递归就好
  public int solutionWithRecursiveSimplified(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(solutionWithRecursive(root.left), solutionWithRecursive(root.right));
  }

  //广度优先遍历
  //核心在分层遍历，然后计算总共遍历了多少层
  //利用Queue，first in first out的特性，按层逐一的遍历节点
  //难点在于如何判断一层结束了没
  //这里利用的是统计每层结束后Queue的大小，然后取出一个减去一个
  //当减到0以后，说明当前层已经遍历完，depth+1，开始遍历下一层
  public int solutionWithIterativeBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while(size-- > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  //深度遍历优先
  //核心在标记每个分支的深度，然后取最大的
  //利用Stack, last in first out的特性，分支遍历每个节点
  //利用第二个Stack来标记每个分支每个节点的深度，当还有子节点的时候，继续向下遍历，直到叶子节点为止
  public int solutionWithIterativeDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }    
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    Stack<Integer> depth = new Stack<>();
    depth.push(1);
    int maxDepth = 0;
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      Integer currentDepth = depth.pop();
      maxDepth = Math.max(currentDepth, maxDepth);
      if (node.right != null) {
        stack.push(node.right);
        depth.push(currentDepth + 1);
      }
      if (node.left != null) {
        stack.push(node.left);
        depth.push(currentDepth + 1);
      }
    }
    return maxDepth;
  }
}