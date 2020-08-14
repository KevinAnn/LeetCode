package com.ex200811;


import java.util.ArrayDeque;
import java.util.Queue;

public class IcofRobotMovingRange {

    private static int count;


    public static void main(String[] args) {
        System.out.println(movingCount(3, 2, 17));
    }

    private static int movingCount(int m, int n, int k) {
        int[][] matrix = new int[m][n];
        // 使用dfs
//        dfs(matrix, k, 0, 0);
        // 使用bfs
        bfs(matrix, k, 0, 0);
        return count;
    }

    /**
     * 深度优先搜索
     */
    private static void dfs(int[][] matrix, int k, int m, int n) {
        if (m < 0 || m > matrix.length - 1 || n < 0 || n > matrix[0].length - 1 || matrix[m][n] == 1 || !canMove(m, n, k)) {
            return;
        }
        // 标记可走的坐标
        matrix[m][n] = 1;
        // 走过的计数+1
        count ++;
        // 因为是从矩阵的左上角看是出发，可以每次只搜索下、右的元素
        dfs(matrix, k, m + 1, n);
        dfs(matrix, k, m, n + 1);
    }

    /**
     * 广度优先搜索
     */
    private static void bfs(int[][] matrix, int k, int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{m, n});
        while (queue.size() > 0) {
            int[] ele  = queue.poll();
            int i = ele[0];
            int j = ele[1];
            if (i < matrix.length && j < matrix[0].length && matrix[i][j] != 1 && canMove(i, j, k)) {
                matrix[i][j] = 1;
                count++;
                // 向下搜索
                queue.add(new int[]{i + 1, j});
                // 向右搜索
                queue.add(new int[]{i, j + 1});
            }
        }
    }

    /**
     * 坐标是否可移动
     * @param x x
     * @param y y
     * @param border 边界值
     */
    private static boolean canMove(int x, int y, int border) {
        return getDigitSum(x) + getDigitSum(y) <= border;
    }

    /**
     * 获取数字各位相加之和
     */
    private static int getDigitSum(int num) {
        int sum = 0;
        int m = 1;
        while (num / m != 0) {
            int n = num % (m * 10) - sum;
            n = n / m;
            sum += n;
            m *= 10;
        }
        return sum;
    }



}
