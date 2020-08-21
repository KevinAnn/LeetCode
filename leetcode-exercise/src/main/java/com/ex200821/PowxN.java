package com.ex200821;
/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * @author An Qi
 * @date 2020/8/21
 */
public class PowxN {

    public static void main(String[] args) {
        double res = myPow3(2.0,-2147483648 );
        System.out.println(res);
    }

    /**
     * 暴力解法
     */
    private static double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        double res = 1;
        long m = n;
        m = m < 0 ? -m : m;
        for (long i = 0; i < m; i++) {
            res = res * x;
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    /**
     * 二分法（递归）
     */
    private static double myPow2(double x, int n){
        if (x == 1 || n == 0) {
            return 1;
        }
        long m = n;
        m = m < 0 ? -m : m;
        double res = myPow2Helper(x, m);
        if (n < 0) {
            return 1 / res;
        } else {
            return res;
        }
    }

    private static double myPow2Helper(double x, long n) {
        if (n == 1) {
            return x;
        }
        double half = myPow2Helper(x, n / 2);
        // 需要判断指数n的奇偶
        // 偶数
        if (n % 2 == 0) {
            return half * half;
        }
        // 奇数
        else {
            return half * half * x;
        }
    }

    /**
     * 二分法（循环）
     */
    private static double myPow3(double x, int n) {
        if (x == 1 || x == 0) {
            return x;
        }
        long m = n;
        // 处理负指数计算
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        double res = 1.0;
        // 二分法（循环）
        while (m > 0) {
            // 判断m是否为奇数，奇数需要多乘一个x
            if ((m & 1) == 1) {
                res *= x;
            }
            x *= x;
            // m / 2
            m >>= 1;
        }
        return res;
    }
}
