package com.ex2101;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 示例1
 * 输入
 * [1,3,5,2,2],5,3
 * 返回值
 * 2
 *
 * @author An Qi
 * @date 2021/1/10
 */
public class FindKth {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 1, 9, 5, 7};
        System.out.println(findKth(arr, 1));
    }

    public static int findKth(int[] arr, int k) {
        return quickSort(arr, 0, arr.length - 1, arr.length - k);
    }

    private static int quickSort(int[] arr, int l, int r, int k) {
        int m = partition(arr, l, r);
        if (m == k) {
            return arr[m];
        } else if (m < k) {
            return quickSort(arr, m + 1, r, k);
        } else {
            return quickSort(arr, l, m - 1, k);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l, j = r - 1;
        while (i <= j) {
            while (i <= j && arr[i] <= arr[r]) {
                i++;
            }
            while (i <= j && arr[j] > arr[r]) {
                j--;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        for (int i1 = 0, i2 = 0; i1 < arr.length; i1++,i2--) {

        }
        int t = arr[i];
        arr[i] = arr[r];
        arr[r] = t;
        return i;
    }

}
