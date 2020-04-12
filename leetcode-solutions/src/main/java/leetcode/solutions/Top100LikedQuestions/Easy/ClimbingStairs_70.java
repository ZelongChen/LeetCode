package leetcode.solutions.Top100LikedQuestions.Easy;

public class ClimbingStairs_70 {
  //这个其实是一个斐波那契数列问题
  //f(n) = f(n-1) + f(n-2)
  //但这个会做大量重复的计算
  //时间复杂度是指数级的，非常慢
  public int solutionFibonaci(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    return solutionFibonaci(n - 1) + solutionFibonaci(n - 2);
  }

  //动态规划
  //用空间换时间
  //把之前的每步f(n-1),f(n-2)都以数组的形式存下来
  public int solutionDP(int n) {
    int[] f = new int[n+2];
    f[1] = 1;
    f[2] = 2;
    for (int i = 3; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  //动态规划
  //用空间换时间
  //把之前的每步f(n-1),f(n-2)都以临时变量的形式存下来
  public int solutionDPWithPreviousValues(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    int fMinus1 = 2;
    int fMinus2 = 1;
    int result = fMinus1;
    for (int i = 3; i <= n; i++) {
      result = fMinus1 + fMinus2;
      fMinus2 = fMinus1;
      fMinus1 = result;
    }
    return result;
  }
}