package com.ex200525;

import com.base.util.Util;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author An Qi
 * @date 2020/5/25
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 2;
        Util.print(searchRange(nums, target));
    }

    private static int[] searchRange(int[] nums, int target) {
        // 目标不在数组中的情况
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        // 二分查找
        int start = 0, end = nums.length - 1, mid, result = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                result = mid;
                break;
            }
        }
        // 查找起始和结束
        if (result == -1) {
            return new int[]{-1, -1};
        } else {
            int left = result, right = result;
            // 向右查找
            for (int i = result + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    right = i;
                } else {
                    break;
                }
            }
            // 想左查找
            for (int i = result - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    left = i;
                } else {
                    break;
                }
            }
            return new int[]{left, right};
        }
    }
}
