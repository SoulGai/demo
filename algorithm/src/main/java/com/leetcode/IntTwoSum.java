package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 两数之和
 * @author: SoulGai
 * @create: 2024-11-17 12:56
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 思路：
 * 使用一个哈希表（Map）存储数组中已经遍历过的元素及其下标。
 * 在遍历过程中，对于当前元素 nums[i]，检查 target - nums[i] 是否已经存在于哈希表中。如果存在，则返回结果。
 * 时间复杂度：O(n)，空间复杂度：O(n)。
 **/
public class IntTwoSum {
    /**
     * 哈希表工作原理：
     * 遍历数组时，对于每个元素，检查是否可以通过当前哈希表中的元素和它配对得到目标值。
     * 如果可以配对，立即返回结果；否则，将当前元素加入哈希表。
     * 效率：
     * 时间复杂度：O(n)，只需遍历一次数组。
     * 空间复杂度：O(n)，用于存储哈希表。
     */
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表存储已经遍历过的元素及其下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 计算需要的补数
            if (map.containsKey(complement)) {
                // 如果补数已经存在，返回对应的下标
                return new int[]{map.get(complement), i};
            }
            // 否则将当前元素及其下标存入哈希表
            map.put(nums[i], i);
        }
        // 如果没有找到，返回空数组
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));
    }
}