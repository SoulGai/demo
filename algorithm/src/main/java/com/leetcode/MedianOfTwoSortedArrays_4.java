package com.leetcode;

/**
 * @program: leetcode
 * @description:
 * @author: SoulGai
 * @create: 2024-12-10 09:10
 **/
public class MedianOfTwoSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int i = left + (right - left) / 2;  // nums1 中的分割点
            int j = halfLen - i;               // nums2 中的分割点

            // 边界条件：左侧可能为空
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // 找到合法分割
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left); // 奇数情况
                } else {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            } else if (nums1Left > nums2Right) {
                right = i - 1; // i 太大，向左移动
            } else {
                left = i + 1; // i 太小，向右移动
            }
        }
        return 0.0; // 理论上不可能走到这里
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2)); // 输出：2.0
    }
}
