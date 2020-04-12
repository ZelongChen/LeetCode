package leetcode.solutions.Top100LikedQuestions.Easy;

public class MaximumSubarray_53 {
  
  /**
   * 利用两个变量，一个记录当前出现过的最大值maxSoFar，一个记录到当前位置的subarray的最大值maxEndingHere
   * 当向后遍历数组的时候，如果当前值nums[i]大于nums[i]+maxEndingHere，说明最大的subarray应该从当前位置从新算起
   * 把maxEndingHere替换成nums[i]
   * 同时把每次的maxEndingHere和maxSoFar比较，记录下曾经出现过的最大的值
   * 当遍历结束的时候，maxSoFar就变成了max of all
   */
  public int solution(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }

  /**
   * 动态规划的方法
   * 把一个问题拆成与之相关的几个小问题之和
   * 要计算从0到n位的数组的最大子数组maxSubArray(nums, 0, n)
   * 相当于比较0到n-1位的数组的最大子数组j加上当前第n位的值和第n位的值谁大
   * maxSubArray(nums, 0, n) = Math.max(maxSubArray(nums, 0, n-1) + nums[n], nums[n])
   * 其实也可以转换成判断：maxSubArray(nums, 0, n-1)是否小于0
   * 因为要是之前最大的都是负数，那肯定就可以直接排除掉，只取当前nums[n]的值就好
   */
  public int solutionDP(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}