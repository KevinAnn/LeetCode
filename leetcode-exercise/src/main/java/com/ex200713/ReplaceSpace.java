package com.ex200713;

import com.util.Util;

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author An Qi
 * @date 2020/7/13
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        Util.print(replaceSpace("We are happy."));
    }

    private static String replaceSpace(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
