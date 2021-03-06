package com.ex200713;

import com.base.util.Util;

/**
 * 剑指 Offer 04. 二维数组中的查找 / 240. 搜索二维矩阵 II
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * @author An Qi
 * @date 2020/7/13
 */
public class IcofSearchA2dMatrixii {

    public static void main(String[] args) {
        int[][] matrix = {
                          {1,   4,  7, 11, 15},
                          {2,   5,  8, 12, 19},
                          {3,   6,  9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}
                        };
        int target = 5;

        Util.print(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 0 && target >= matrix[i][0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target < matrix[i][j]) {
                        break;
                    }
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

}
