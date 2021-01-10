package com.ex200518;

import com.base.util.Util;

/**
 * @Description: 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @Author: An Qi
 * @Date: 2020/5/18
 */
public class ZuoXuanZhuanZiFuChuanLcof {

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        Util.print(reverseLeftWords(s, n));
        Util.print(reverseLeftWords2(s, n));
    }

    private static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    private static String reverseLeftWords2(String s, int n) {
        String res = "";
        int len = s.toCharArray().length;
        for (int i = n; i < n + len; i++) {
            // 通过取余获取从n位置字符到n-1位置字符
            res += s.charAt(i % len);
        }
        return res;
    }
}
