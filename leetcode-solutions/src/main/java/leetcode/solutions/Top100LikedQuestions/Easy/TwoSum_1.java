package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum_1 {

  //遍历两次数组，然后找到两个对应的值
  public int[] solutionWithDoubleIteration(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }

  //因为这题要的是对应值的坐标，所以不能用排序队列两边逼近的方式
  //因为数组本身是无序的，排序之后位置变了
  //如果是让返回两个对应的值，那可以
  public int[] solutionWithSortedArray(int[] nums, int target) {
    Arrays.sort(nums);
    int head = 0;
    int tail = nums.length - 1;
    while (head < tail) {
      if (nums[head] + nums[tail] == target) {
        return new int[] {head, tail};
      } else if (nums[head] + nums[tail] < target) {
        head++;
      } else {
        tail--;
      }
    }
    return null;
  }

  //利用map来存value和index配对
  public int[] solutionWithMapOfList(int[] nums, int target) {
    Map<Integer, List<Integer>> map  = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
    for (int key : map.keySet()) {
      int expected = target - key;
      if (map.containsKey(expected)) {
        if (key == expected) {
          return new int[] {map.get(key).get(0), map.get(key).get(1)};
        } else {
          return new int[] {map.get(key).get(0), map.get(expected).get(0)};
        }
      }
    }
    return null;
  }

  public int[] solutionWithMapTwoIteration(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int expected = target - nums[i];
      if (map.containsKey(expected) && map.get(expected) != i) {
        return new int[] {map.get(expected), i};
      }
    }
    return null;
  }

  public int[] solutionWithMapSingleIteration(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int expected = target - nums[i];
      if (map.containsKey(expected) && map.get(expected) != i) {
        return new int[] {map.get(expected), i};
      }
      //把put放在判断后面，这样能避免遇到重复的值，而不知道是哪一个的问题 
      map.put(nums[i], i);
    }
    return null;
  }
}