package com.ex200519;


import com.base.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 9-回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例：
 * 输入: 121
 * 输出: true
 *
 * @author An Qi
 * @date  2020/5/19
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 1000000001;
        Util.print(isPalindrome(x));
    }

    /**
     * 将x整体翻转，用翻转后的结果与x比较
     *
     * @param x
     * @return
     */
    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        // 提取各位上的数字
        List<Long> numList = new ArrayList<>();
        long digit = 10;
        while (x / (digit / 10) != 0) {
            numList.add((x % digit) / (digit / 10));
            digit = digit * 10;
        }
        // 拼接反转后的数字
        int reverse = 0;
        for (int i = numList.size() - 1, reverseDigit = 1; i >= 0; i--, reverseDigit = reverseDigit * 10) {
            reverse += numList.get(i) * reverseDigit;
        }
        return reverse == x;
    }

    /**
     * 将x翻转一半，对比一半与另一半
     * @param x
     * @return
     */
    private static boolean isPalindrome2(int x) {
        // 过滤特殊情况
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 翻转
        int a = 0;
        // 通过x > a判断是否过半
        while (x > a) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        return x == a || x == a / 10;
    }

    /**
     * 先获取x的位数，再提取第一位和最后一位进行比较
     *
     * @param x
     * @return
     */
    private static boolean isPalindrome3(int x) {
        //边界判断
        if (x < 0) {
            return false;
        }
        int div = 1;
        // 获取最高位数
        while (x / div >= 10) {
            div *= 10;
        }
        // 比较
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

}
