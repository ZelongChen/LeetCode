package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.Arrays;

public class HouseRobber_198 {

  //对于这类动态规划的题目，最重要的是要拆解问题，找出前后之间的关联
  //一般就是两种解法，循环和递归
  /**
   * 1. 找出递归的关联性
   *    对于robber，面对每一间房子i，他只有两个选择
   *      a. 抢这个房子
   *      b. 不抢这个房子
   *    如果他选择a，那他就不能抢i-1的房子，但是他可以任意抢i-2及之前的房子
   *    如果他选择b，他就可以任意抢i-1及之前的房子
   * 
   *    这样问题就变成一下两个情况哪个赚更多
   *      a. 当前房子i的钱+i-2之前房子的钱
   *      b. i-1之前房子的钱
   *    从后往前推，可以得到获利最大的公式
   *    rob(i) = Math.max(rob(i - 2) + currentValue, rob(i - 1))
   */

  //递归法(top-bottom)
  //直接用递归的方法实现上面那个公式
  //代码简单，但是时间复杂度是指数级的，中间步骤有太多重复性的计算了
  public int solutionRecursive(int[] nums) {
    return robRecursive(nums, nums.length - 1);
  }

  public int robRecursive(int[] nums, int i) {
    if (i < 0) {
      return 0;
    }
    return Math.max(robRecursive(nums, i - 2) + nums[i], robRecursive(nums, i - 1));
  }

  //还是用递归的方式，但是利用数组记录下中间的过程，后面就可以重复用，不需要再算一次
  //利用全局变量memo，记录下每一个位置的当前最大值，这样后面遇到的时候就可以直接调用
  //复杂度降为n
  int[] memo;
  public int solutionRecursiveWithMemo(int[] nums) {
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return robRecursiveWithMemo(nums, nums.length - 1);
  }

  public int robRecursiveWithMemo(int[] nums, int i) {
    if (i < 0) {
      return 0;
    }
    if (memo[i] >= 0) {
      return memo[i];
    }
    int max = Math.max(robRecursiveWithMemo(nums, i - 2) + nums[i], robRecursiveWithMemo(nums, i - 1));
    memo[i] = max;
    return max;
  }

  //循环法(bottom-up)
  //根据前面的例子，我们可以发现，其实关键在于记录下每一步的当前最大值
  //这样我们就可以用数组存来存这些值，然后从下往上计算
  public int solutionIterativeWithArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] memo = new int[nums.length + 1]; 
    memo[0] = 0;
    memo[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      memo[i+1] = Math.max(memo[i-1] + nums[i], memo[i]);
    }
    return memo[memo.length - 1];
  }

  //根据上面的方式，我们可以再进一步简化
  //我们发现其实只需要存之前两步的值就行了，不需要用到一个数组
  public int solutionIterativeWithTmpVariables(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int prev2 = 0;
    int prev1 = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(prev2 + nums[i], prev1);
      prev2 = prev1;
      prev1 = max;
    }
    return max;
  }
}