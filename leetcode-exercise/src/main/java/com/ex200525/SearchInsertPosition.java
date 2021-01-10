package com.ex200525;

import com.base.util.Util;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author An Qi
 * @date 2020/5/25
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 8, 9};
        int target = 10;
        Util.print(searchInsert(nums, target));
    }

    /**
     * 二分查找
     */
    private static int searchInsert(int[] nums, int target) {
        // 先判断数组外的情况
        if (target <= nums[0]) {
            return 0;
        } else if (target >= nums[nums.length - 1]) {
            return nums.length;
        }
        // 二分查找
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }
        return start;
    }



}
