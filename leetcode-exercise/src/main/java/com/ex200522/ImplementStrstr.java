package com.ex200522;

import com.base.util.Util;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author An Qi
 * @date 2020/5/22
 */
public class ImplementStrstr {

    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        Util.print(strStr(haystack, needle));
    }

    /**
     * 子串检索
     */
    private static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }



}
