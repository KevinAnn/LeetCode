package com.ex2101;

import com.base.data.ListNode;
import com.base.util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @author An Qi
 * @date 2021/1/10
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        Util.print(getLeastNumbers(arr, 4));
    }


    public static int[] getLeastNumbers(int[] arr, int k) {
        // 构建堆
        for (int i = k / 2 + 1; i >= 0; i--) {
            buildHeap(arr, i, k);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                int t = arr[i];
                arr[i] = arr[0];
                arr[0] = t;
                buildHeap(arr, 0, k);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
           res[i] = arr[i];
        }
        return res;
    }

    private static void buildHeap(int[] arr, int root, int len) {
        // 左叶子节点
        int i = root * 2 + 1;
        if (i >= len) {
            return;
        }
        // 比较叶子节点
        if (i + 1 < len && arr[i] < arr[i + 1]) {
            i++;
        }
        // 比较根节点
        if (arr[root] < arr[i]) {
            int t = arr[root];
            arr[root] = arr[i];
            arr[i] = t;
            buildHeap(arr, i, len);
        }
    }


}
