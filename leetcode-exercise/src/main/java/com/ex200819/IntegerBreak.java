package com.ex200819;

public class IntegerBreak {


    public static void main(String[] args) {
        int res = integerBreak3(120);
        System.out.println(res);
    }


    /**
     * 1.暴力解法
     * 先将将n拆分成两个数的乘积：i * (n-1)
     * 再将两个数乘积进行递归，得到多个数的乘积: i * f(n-i)
     * 获取最大值
     */
    private static int integerBreak1(int n) {
        if (n == 2) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak1(n - i)));
        }
        return res;
    }

    static int[] arr;
    private static int integerBreak2(int n) {
        arr = new int[n + 1];
        return integerBreak21(n);
    }

    private static int integerBreak21(int n) {
        if (n == 2) {
            return 1;
        }
        // 实用之前计算过的值
        if (arr[n] > 0) {
            return arr[n];
        }
        // 计算
        int res = 0;
        // 只需要计算n的一半，因为超过之后会重复
        for (int i = 1; i < (n / 2 + 1); i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak21(n - i)));
        }
        // 保存计算结果
        arr[n] = res;
        return res;
    }

    /**
     * 动态规划
     */
    private static int integerBreak3(int n) {
        arr = new int[n + 1];
        arr[2] = 1;
        // 计算并保存每个节点的值
        for (int i = 3; i <= n; i++) {
            // 计算
            for (int j = 1; j < i; j++) {
                arr[i] = Math.max(arr[i], Math.max(j * (i - j), j * arr[i - j]));
            }
        }
        return arr[n];
    }

}
