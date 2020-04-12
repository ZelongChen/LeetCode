package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.solutions.Tools.TreeNode;

public class SymmetricTree_101 {

  //递归法
  //一个树是对称的，说明他的两边子树互为镜像
  //这说明两点
  //1. 两个根节点的值相同
  //2. 根节点1的左边子树和根节点2的右边子树互为镜像，同理，根节点1的右边子树和根节点2的左边子树互为镜像
  public boolean solutionRecursive(TreeNode root) {
    return isMirror(root, root);
  }

  private boolean isMirror(TreeNode node1, TreeNode node2) {
    //这样写挺巧妙的，先判断二者不同时为null,后面一步只需要判断二者不存在一个为null
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null) {
      return false;
    }
    return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
  }

  //循环法
  //跟上面同理，假设有两个树，然后依次遍历每个节点
  //同时比较每个节点1的左边节点和节点2的右边节点相同，节点1的右边节点和节点2的左边节点相同
  public boolean solutionIterative(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    //巧妙在这里，同时offer两次root，这样就好象是两个树在进行比较
    queue.offer(root);
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node1 = queue.poll();
      TreeNode node2 = queue.poll();
      if (node1 == null && node2 == null) {
        continue;
      }
      if (node1 == null || node2 == null) {
        return false;
      }
      if (node1.val != node2.val) {
        return false;
      }
      queue.offer(node1.left);
      queue.offer(node2.right);
      queue.offer(node1.right);
      queue.offer(node2.left);
    }
    return true;
  }
}