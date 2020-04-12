package leetcode.solutions.Top100LikedQuestions.Easy;

public class MoveZeros_283 {
    // 冒泡法，把0都往上移就可以了，但是很慢
    public void moveZerosBubbleUp(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
    // 双指针法
    // 第一个指针指向0，第二个指针指向下一个非0的值，然后把值互换
    // 接着把第一个指针移动到第二个指针的位置，继续移动第二个指针
    // 直到第二个指针移动到数组的结尾
    public void moveZerosDoublePointers(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            //在发现第一个0之前，两个指针一起往前移
            if (nums[left] != 0) {
                left++;
                right++;
            } else {
                //发现第一个0之后，第一个指针不动，第二个指针往前移
                //第二个指针一直往前移，直到发现第一个非0的值
                //这个时候，两个指针之间的值都为0
                if (nums[right] == 0) {
                    right++;
                } else{
                    //将两个指针指向的值交换
                    //第一个指针向前移动一位
                    //这样保证第一个指针一直指向第一个0值
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                }
            }
        }    
    }

}