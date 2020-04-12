package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.solutions.Tools.TreeNode;

public class InvertBinaryTree_226 {
  
  public TreeNode invertTreeRecursive(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode right = invertTreeRecursive(root.right);
    TreeNode left = invertTreeRecursive(root.left);
    root.left = right;
    root.right = left;
    return root;
  }

  public TreeNode invertTreeIterative(TreeNode root) {
    if (root == null) {
      return root;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      TreeNode left = node.left;
      TreeNode right = node.right;
      node.left = right;
      node.right = left;
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return root;
  }
}