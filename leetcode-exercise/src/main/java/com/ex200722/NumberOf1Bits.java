package com.ex200722;

import com.base.util.Util;

/**
 * 191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * 思路：
 * 通过对二进制进行运算来判断最后一位是0还是1，判断n次直到目标数归零，统计1出现的个数
 * 1.目标数&1
 * &1后，最后一位为0则结果为0，为1则结果为1，统计结果是否为1，之后再将目标数右移一位判断下一位，直到目标数为0
 *
 * 2.n & (n-1)
 * n & (n-1)会将n的最后一个1消去，之前位保持不变，因此执行m次后可将1消完导致n=0，故m为n中1的个数
 *
 * @author An Qi
 * @date 2020/7/22
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = hammingWeight2(23);
        Util.print(n);
    }

    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                sum++;
            }
            n = n >>> 1;
        }
        return sum;
    }

    public static int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum ++;
        }
        return sum;
    }

}
