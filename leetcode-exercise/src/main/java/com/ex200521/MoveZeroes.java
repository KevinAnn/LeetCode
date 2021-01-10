package com.ex200521;

import com.base.util.Util;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author An Qi
 * @date 2020/5/21
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        Util.print(nums);
    }

    /**
     * 双指针
     */
    private static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
                i++;
            }
        }
    }

}
