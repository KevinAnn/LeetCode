package com.ex200520;

import com.util.Util;

/**
 * 26-删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author An Qi
 * @date 2020/5/20
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        Util.print(removeDuplicates(nums));
        Util.print(nums);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // 相同的数字个数 = 比较时跳过的长度
        int skip = 0;
        for (int i = 0; i < nums.length - 1 - skip; i++) {
            for (int j = i + 1 + skip; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    len--;
                    skip++;
                }
                if (nums[i] < nums[j]) {
                    break;
                }
            }
            // 将下一个不同的数字交换到下一位
            if (i + 1 + skip < nums.length) {
                nums[i + 1] = nums[i + 1 + skip];
            }
        }
        return len;
    }

    private static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
