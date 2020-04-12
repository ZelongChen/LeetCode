package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.Arrays;

public class MajorityElement_169 {
    //偷懒的方法
    //对数组排序，然后取中间位置的值
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}