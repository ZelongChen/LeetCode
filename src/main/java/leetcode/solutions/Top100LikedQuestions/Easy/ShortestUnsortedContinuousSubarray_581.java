package leetcode.solutions.Top100LikedQuestions.Easy;

public class ShortestUnsortedContinuousSubarray_581 {
  //其实这题可以把问题拆解成，这个我们要找的子数组前面prefix array和后面suffix array的数都是有序递增的
  //然后只要将子数组排下序，就可以变成整个数组有序递增
  //但这要求，子数组里的最小的值，不大于prefix array的最后一个值
  //子数组里最大的值，不大于suffix array里的第一个值
  //这样子数组怎么排序都不会影响到前后两个数组
  //这样，我们可以得到暴力解法
  //先从前向后遍历数组，一旦找到一个不是有序递增的值
  //就把这个值跟前面出现过的有序递增值做比较，找到如果重新排序后他应该在哪个位置
  //遍历一遍以后，找到这个需要重新排序的最靠左的位置
  //同理，从右向左也遍历一遍，找到需要重新排序的最靠右的位置
  //如果right <= left，说明已经排好了，返回0
  //不然返回二者之间的差值
  public static int solutionBrutal(int[] nums) {
    int left = nums.length - 1;
    int right = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] < nums[i]) {
        for (int j = 0; j <= i; j++) {
          if (nums[j] > nums[i + 1]) {
            left = Math.min(j, left);
          }
        }
      }
    }
    for (int i = nums.length - 1; i > left; i--) {
      if (nums[i - 1] > nums[i]) {
        for (int j = nums.length - 1; j >= i; j--) {
          if (nums[j] < nums[i - 1]) {
            right = Math.max(j, right);
          }
        }
      }
    }
    if (right <= left) {
      return 0;
    }
    return right - left + 1;
  }

  //其实根据上面的分析，我们可以把问题简化成
  //找到未排序子数组的最小值，然后跟prefix array做比较，找到排序后他应该在的位置
  //这个位置标记为left
  //找到未排序子数组的最大值，然后跟suffix array做比较，找到排序后他应该在的位置
  //这个位置标记为right
  //两个坐标之间的子数组，就是我们最终要找的数组
  public static int solution(int[] nums) {
    boolean flag = false;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 1; i++) {
      if (!flag && nums[i + 1] < nums[i]) {
        flag = true;
      }
      if (flag) {
        min = Math.min(min, nums[i + 1]);
      }
    }
    flag = false;
    int max = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i > 0; i--) {
      if (!flag && nums[i - 1] > nums[i]) {
        flag = true;
      }
      if (flag) {
        max = Math.max(max, nums[i - 1]);
      }
    }
    int left = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > min) {
        left = i;
        break;
      }
    }
    int right = 0;
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i] < max) {
        right = i;
        break;
      }
    }
    return left >= right ? 0 : right - left + 1;
  }

  public static void main(String[] args) {
    solution(new int[]{2,6,4,8,10,9,15});
  }
}