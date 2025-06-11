package com.leetcode;

/**
 * @program: leetcode
 * @description: 最长公共前缀
 * @author: SoulGai
 * @create: 2024-11-17 16:59
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"] 输出："fl"
 * 输入：strs = ["dog","racecar","car"]    输出：""
 **/
public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"", "b", "c"};
        //水平扫描
        System.out.println("水平扫描最长公共前缀是: " + longestCommonPrefix(strs1)); // "fl"
        System.out.println("水平扫描最长公共前缀是: " + longestCommonPrefix(strs2)); // ""
        System.out.println("水平扫描最长公共前缀是: " + longestCommonPrefix(strs3)); // ""
        //垂直扫描
        System.out.println("垂直扫描最长公共前缀是: " + verticalLongestCommonPrefix(strs1)); // "fl"
        System.out.println("垂直扫描最长公共前缀是: " + verticalLongestCommonPrefix(strs2)); // ""
        System.out.println("垂直扫描最长公共前缀是: " + verticalLongestCommonPrefix(strs3)); // ""



    }

    /**
     * 水平扫描法： 适合字符串数量较少或字符数不均的情况。
     * 将第一个字符串作为基准，依次和后面的字符串进行比较，找出公共前缀。
     * 每次比较时更新公共前缀。
     * 如果某个字符串没有公共前缀，则返回空字符串。
     * 时间复杂度：O(S)，其中 S 是所有字符串中字符的总数。
     * 空间复杂度：O(1)，除了输入字符串外不使用额外空间。
     * 优点：直观，易于理解。
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 以第一个字符串为基准，逐个与其他字符串进行比较
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 比较基准字符串与当前字符串的公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                // 每次去掉前缀的最后一个字符，直到找到公共前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 垂直扫描法：适合字符串数量多，且字符串的长度大致相同的情况。
     * 比较每个字符串的同一位置的字符。
     * 如果出现不相等的字符，说明公共前缀结束。
     * 时间复杂度：O(S)，其中 S 是所有字符串中字符的总数。
     * 空间复杂度：O(1)，不需要额外的空间。
     * 优点：不需要逐个删除公共前缀，可以直接按字符比较。
     * @param strs
     * @return
     */
    public static String verticalLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 找到最短的字符串长度，以此作为比较的上限
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // 遍历每个字符位置，比较所有字符串的字符
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != currentChar) {
                    return strs[0].substring(0, i); // 返回到当前字符的位置
                }
            }
        }
        return strs[0].substring(0, minLength); // 返回最短字符串
    }

}
