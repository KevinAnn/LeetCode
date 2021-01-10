package com.ex200522;

import com.base.util.Util;

/**
 * 459. 重复的子字符串
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * @author An Qi
 * @date 2020/5/22
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        String s = "";
        Util.print(repeatedSubstringPattern(s));
    }

    /**
     * 本题关键点在于寻找判断是否由重复子串构成的特征，
     * 若由重复子串构成，则s移位<n次后仍旧和变成s，
     * 即：
     * abcabc
     * 转变:cabcab
     * 改变两次:bcabca
     * 改变三次:abcabc
     * 由于在s很长的情况下，完成移动操作效率很低，
     * 因此使s2=s+s，当移动到第二个s之前时出现相同串则表示含有重复子串
     */
    private static boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) {
            return false;
        }
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}
