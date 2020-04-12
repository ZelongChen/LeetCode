package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_448 {
    //一般遇到这种对数组里的值有大小限制的，都可以把它转换成另一个数组，以值为index，以出现次数为value
    //利用第二个数组counts来统计每个数字出现的次数，没有出现过的值为0
    public List<Integer> solutionWithAdditionalSpace(int[] nums) {
        int[] counts = new int[nums.length + 1];
        for (int i : nums) {
            int tmp = counts[i];
            counts[i] = tmp + 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
    //因为数组的值被限定在数组的大小之内，所以可以以值为index来进行操作
    //不需要额外空间，利用数组本身
    //遍历数组，取每个位置值的绝对数，以它为index，把对应的位置的值改为负数
    //这样每个出现过的值所对应的index的value都被改成负数了，没有被改为负数的说明那个index所对应的值没有出现过
    public List<Integer> solutionByMarkingPresentValueToNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = - nums[val];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}