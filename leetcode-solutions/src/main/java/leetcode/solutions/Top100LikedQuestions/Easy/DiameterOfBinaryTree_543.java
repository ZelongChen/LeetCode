package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.solutions.Tools.TreeNode;

public class DiameterOfBinaryTree_543 {

  //遍历每个节点，然后算出每个节点左右的深度，之和就是以该节点为中心节点得到的diameter
  //对于每个节点得到的diameter，和当前最大做比较，保留大的
  //最后得到最大的diameter
  public int solutionWithIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int diameter = 0;
    while(!queue.isEmpty()) {
      TreeNode node = queue.poll();
      int leftDepth = 0;
      int rightDepth = 0;
      if (node.left != null) {
        queue.offer(node.left);
        leftDepth = maxtDepth(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
        rightDepth= maxtDepth(node.right);
      }
      diameter = Math.max(diameter, leftDepth + rightDepth);
    }
    return diameter;
  }

  //递归的方法
  //对于每个节点，计算它自己为中间节点的diamter，它左子节点的diameter，右子节点的diameter，然后返回三者中最大的
  public int solutionWithRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }    
    int rootDiameter = maxtDepth(root.left) + maxtDepth(root.right);
    int leftDiameter = solutionWithRecursive(root.left);
    int rightDiameter = solutionWithRecursive(root.right);
    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
  }

  private int maxtDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxtDepth(root.left), maxtDepth(root.right));
  }
}