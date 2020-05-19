package com.ex200519;

import com.util.Util;

/**
 * 14-最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * @author An Qi
 * @date 2020/5/19
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"aa","a"};
        Util.print(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = "";
        char[] first = strs[0].toCharArray();;
        // 遍历第一个单词的字母
        for (int i = 0; i < first.length; i++) {
            // 遍历数组中的其他单词
            boolean same = true;
            for (int j = 1; j < strs.length; j++) {
                // 遇到长度最小的单词，中断循环
                if (i > strs[j].length() - 1) {
                    same = false;
                    break;
                }
                char[] other = strs[j].toCharArray();
                if (first[i] != other[i]) {
                    same = false;
                }
            }
            if (same) {
                res += first[i];
            } else {
                break;
            }
        }
        return res;
    }
}
