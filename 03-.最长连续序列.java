import java.util.*;

class Solution {
    /*
     * 128. 最长连续序列
     * 难度: 中等
     *
     * 题意概括:
     * 给定一个未排序的整数数组 nums，找出数字连续的最长序列长度。
     * 要求时间复杂度尽量做到 O(n)。
     *
     * 示例 1:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]
     *
     * 示例 2:
     * 输入: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
     * 输出: 9
     *
     * 示例 3:
     * 输入: [1, 0, 1, 2]
     * 输出: 3
     *
     * 提示:
     * 0 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     *
     * 思考方向:
     * 1. 如果先排序，为什么时间复杂度不满足最优要求
     * 2. 如何用 HashSet 把查找某个数是否存在优化到 O(1)
     * 3. 为什么只从连续序列的起点开始往后枚举，才能避免重复计算
     */
    public int longestConsecutive(int[] nums) {
        // TODO: 先自己写一版，写完后我帮你一起复盘
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) { // 只从连续序列
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }
    /*

你这套思路里最关键的两步都做对了：

先把所有数丢进 HashSet，完成去重，并把“某个数是否存在”的查询降到 O(1)
遍历集合时，只从“序列起点”开始向后扩展，也就是 !numSet.contains(num - 1) 的时候才进入 while
这里我帮你纠正一句表述，你不是“从最小的数字开始”，而是“从每一段连续序列的起点开始”。
比如 [100, 4, 200, 1, 3, 2]：

1 是一段起点，因为没有 0
100 是一段起点，因为没有 99
200 是一段起点，因为没有 199
2/3/4 都不是起点，因为它们前面还有数
这就是这题能做到 O(n) 的原因：每个数不会被反复当作起点去扫。

你的代码还有两个值得你记住的点：

for (int num : numSet) 遍历去重后的集合是对的，避免重复处理
空数组也没问题，longest 初始为 0，最后会直接返回 0
    */
}
