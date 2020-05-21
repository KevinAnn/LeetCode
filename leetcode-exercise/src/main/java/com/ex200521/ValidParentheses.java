package com.ex200521;

import com.util.Util;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * @author An Qi
 * @date 2020/5/21
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "(]";
        Util.print(isValid(s));
    }

    /**
     * 使用栈，左括号入栈，右括号出栈
     */
    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            // 遇到左括号入栈，遇到对应的右括号出栈
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || stack.pop() != getLeft(s.charAt(i))) {
                return false;
            }
        }
        // 栈中无元素表示括号均成对
        return stack.isEmpty();
    }

    /**
     * 获取对应的左括号
     */
    private static char getLeft(char right) {
        switch (right) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return '#';
        }
    }

}
