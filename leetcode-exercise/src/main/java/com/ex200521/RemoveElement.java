package com.ex200521;

import com.util.Util;

/**
 * 27-移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author An Qi
 * @date 2020/5/21
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1};
        int val = 1;
        Util.print(removeElement2(nums, val));
        Util.print(nums);
    }

    /**
     * 双指针
     * i：待换位元素
     * j：待比对元素
     * 遇到不同元素，将不同元素换至待换位元素
     * 移动元素的次数等于非相同元素的数量
     */
    private static int removeElement(int[] nums, int val) {
        // 特殊值处理
        if (nums.length == 0) {
            return 0;
        }
        // 无需删除的index
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 判断当前元素与给定值是否相等
            if (nums[j] != val) {
                // 元素互换
                // 由于无需考虑删除后的元素，可以直接赋值，无需互换
                nums[i] = nums[j];
                i++;
            }
        }
        // 此时i为无需删除的最后一个元素index，i+1则无需删除元素个数，i
        return i;
    }

    /**
     * 遇到相同元素，将相同元素移至最后一位
     * 移动元素的次数等于相同元素的数量
     */
    private static int removeElement2(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        // 最后一个元素index
        int n = nums.length - 1;
        for (int i = 0; i < n + 1; i++) {
            // 将目标元素移至数组尾部
            if (nums[i] == val) {
                nums[i] = nums[n];
                n--;
                i--;
            }
        }
        return n + 1;
    }


}
