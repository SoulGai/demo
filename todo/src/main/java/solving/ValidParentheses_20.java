package com.leetcode;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 有效的括号
 * @author: SoulGai
 * @create: 2024-11-17 17:11
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 输入：s = "()"       true
 * 输入：s = "()[]{}"   true
 * 输入：s = "(]"       false
 * 输入：s = "([])"     true
 **/

public class ValidParentheses_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([)]")); // false
        System.out.println(isValid("{[]}")); // true
    }

    public static boolean isValid(String s) {
        // 使用栈来存储左括号
        Stack<Character> stack = new Stack<>();

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果是左括号，则压入栈中
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 如果是右括号，检查栈顶元素是否匹配
            else if (c == ')' || c == '}' || c == ']') {
                // 如果栈为空，说明没有对应的左括号
                if (stack.isEmpty()) {
                    return false;
                }
                // 弹出栈顶元素并检查是否匹配
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // 如果栈为空，说明所有的括号都匹配
        return stack.isEmpty();
    }
}
