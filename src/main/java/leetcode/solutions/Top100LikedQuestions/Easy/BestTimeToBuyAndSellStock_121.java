package leetcode.solutions.Top100LikedQuestions.Easy;

public class BestTimeToBuyAndSellStock_121 {
  //创建一个新的数组，存储计算出来的每两天之间的价格差
  //累加每天之间的价格差，如果小于0了就从新开始累加
  //保存出现过的累计最大价差，这个就是最大获利
  public int solutionWithAdditionalArray(int[] prices) {
    if (prices.length == 0) return 0;
    int[] profits = new int[prices.length - 1];
    for (int i = 0; i < prices.length - 1; i++) {
      profits[i] = prices[i + 1] - prices[i];
    }
    int maxProfit = 0;
    int tmp = 0;
    for (int profit : profits) {
      if (tmp + profit < 0) {
        tmp = 0;
      } else {
        tmp += profit;
        if (tmp > maxProfit) {
          maxProfit = tmp;
        }
      }
    }
    return maxProfit;
  }
  //同样的方法，但是每两天的差值存在原来的数组上
  //节省内存，但是需要问清楚可不可以改变原来的数组的值
  public int solutionWithSameArray(int[] prices) {
    for (int i = 0; i < prices.length - 1; i++) {
      prices[i] = prices[i + 1] - prices[i];
    }
    int maxProfit = 0;
    int tmp = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (tmp + prices[i] < 0) {
        tmp = 0;
      } else {
        tmp += prices[i];
        if (tmp > maxProfit) {
          maxProfit = tmp;
        }
      }
    }
    return maxProfit;
  }
  //双指针法，一个指针指向买入，一个指针指向卖出
  //在卖出指针往后移动的时候，判断当前差值，和当前最大获利比较，取大的值，替换当前最大获利
  //当二者差值为负，把买入指针移到卖出指针
  //最后得到最大获利
  public int solutionWithDoublePointers(int[] prices) {
    int maxProfit = 0;
    int buyPointer = 0;
    int sellPointer = 1;
    while(sellPointer < prices.length) {
      if (prices[sellPointer] - prices[buyPointer] > maxProfit) {
        maxProfit = prices[sellPointer] - prices[buyPointer];
      }
      if (prices[sellPointer] - prices[buyPointer] < 0) {
        buyPointer = sellPointer;
      }
      sellPointer++;
    }
    return maxProfit;
  }
}