package leetcode.solutions.Top100LikedQuestions.Easy;

public class SingleNumber_136 {
    // Number xor Number = 0
    // Number xor 0 = Number
    // When xor all the numbers from the array, the non-single numbers will become 0
    // and the only single number xor this 0, will be itself
    // so the result will just be this single number
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber = singleNumber ^ num;
        }
        return singleNumber;
    }
}