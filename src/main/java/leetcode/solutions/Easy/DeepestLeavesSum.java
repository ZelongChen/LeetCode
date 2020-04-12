package leetcode.solutions.Easy;

import java.util.HashMap;
import java.util.Map;
import leetcode.solutions.Tools.TreeNode;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> valueMap = new HashMap<>();
        int deepestLevel = deepestLeavesSum(root, valueMap, 0);
        return valueMap.get(deepestLevel);
     }

     private int deepestLeavesSum(TreeNode root, Map<Integer, Integer> valueMap, int level) {
        int levelLeft = level;
        int levelRight = level;
        if (root != null) {
            // if (valueMap.containsKey(level)) {
            //     valueMap.put(level, root.val + valueMap.get(level));
            // } else {
            //     valueMap.put(level, root.val);
            // }
            valueMap.compute(level, (key, value) -> value != null ? value + root.val : root.val);
            if (root.left != null) {
                levelLeft = deepestLeavesSum(root.left, valueMap, level+1);
            }
            if (root.right != null) {
                levelRight = deepestLeavesSum(root.right, valueMap, level+1);
            }
        }
        return Math.max(levelLeft, levelRight);
    }
}