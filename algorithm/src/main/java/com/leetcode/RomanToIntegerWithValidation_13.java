package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 罗马数字转整数
 * @author: SoulGai
 * @create: 2024-11-17 14:53
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 **/
public class RomanToIntegerWithValidation_13 {
    public static void main(String[] args) {
        System.out.println("罗马数字 III 转换为整数: " + romanToInt("III")); // 3
        System.out.println("罗马数字 IV 转换为整数: " + romanToInt("IV")); // 4
        System.out.println("罗马数字 IX 转换为整数: " + romanToInt("IX")); // 9
        System.out.println("罗马数字 MCMXCIV 转换为整数: " + romanToInt("MCMXCIV")); // 1994
        System.out.println("罗马数字 IIII 转换为整数: " + romanToInt("IIII")); // Invalid input
        System.out.println("罗马数字 IC 转换为整数: " + romanToInt("IC")); // Invalid input
    }

    public static int romanToInt(String s) {
        // 定义罗马数字和对应的整数值
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // 验证输入是否为合法罗马数字
        if (!isValidRoman(s, romanMap)) {
            System.out.println("Invalid input: " + s);
            return -1; // 或抛出异常
        }

        int total = 0; // 最终的结果
        int prevValue = 0; // 前一个字符的数值

        // 从右到左遍历罗马数字
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // 如果当前值小于之前的值，则减去当前值；否则加上当前值
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            // 更新前一个值
            prevValue = currentValue;
        }

        return total;
    }

    public static boolean isValidRoman(String s, Map<Character, Integer> romanMap) {
        // 1. 检查是否包含无效字符
        for (char c : s.toCharArray()) {
            if (!romanMap.containsKey(c)) {
                return false;
            }
        }

        // 2. 检查是否存在连续四个相同字符
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.charAt(i) == s.charAt(i + 1) &&
                    s.charAt(i + 1) == s.charAt(i + 2) &&
                    s.charAt(i + 2) == s.charAt(i + 3)) {
                return false;
            }
        }

        // 3. 检查非法组合
        //   a. I 只能放在 V 和 X 左边
        //   b. X 只能放在 L 和 C 左边
        //   c. C 只能放在 D 和 M 左边
        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);

            if (current == 'I' && (next != 'V' && next != 'X' && romanMap.get(current) < romanMap.get(next))) {
                return false;
            }
            if (current == 'X' && (next != 'L' && next != 'C' && romanMap.get(current) < romanMap.get(next))) {
                return false;
            }
            if (current == 'C' && (next != 'D' && next != 'M' && romanMap.get(current) < romanMap.get(next))) {
                return false;
            }
        }

        return true;
    }
}

