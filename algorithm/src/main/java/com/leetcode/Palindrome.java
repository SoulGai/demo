package com.leetcode;

/**
 * @program: leetcode
 * @description: 回文数
 * @author: SoulGai
 * @create: 2024-11-17 13:44
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数：是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 输入：x = 121  输出：true
 * 输入：x = -121 输出：false
 * 输入：x = 10 输出：false
 **/
public class Palindrome {
    /** 数学法：不需要额外空间，性能更优
     * 利用整数反转的方法，计算原数字的反转值。
     * 如果原数字和反转值相等，则是回文数。
     * 为了优化，可以只反转数字的一半，避免溢出。
     */
    public static boolean isPalindrome(int x) {
        // 负数和以 0 结尾（但不是 0）的数一定不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            // 将数字的一半反转
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // 如果是回文数，x 应该等于反转的数字，或等于去掉中间位后的反转数字
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(98789));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(13));

    }
}