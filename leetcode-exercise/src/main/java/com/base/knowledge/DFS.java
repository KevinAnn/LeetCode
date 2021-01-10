package com.base.knowledge;

import com.base.util.Util;

/**
 * 深度优先搜索遍历图
 *
 * @author An Qi
 * @date 2020/8/4
 */
public class DFS {

    /** 记录元素是否被访问 */
    private static boolean[] visited;

    /** 需遍历的图 */
    private static int[][] map;

    static{
        initGraph(7);
        buildGraph(0, 1);
        buildGraph(0, 2);
        buildGraph(0, 3);
        buildGraph(1, 4);
        buildGraph(1, 5);
        buildGraph(2, 6);
        buildGraph(3, 6);
    }

    /**
     * 初始化图
     * @param size 容量
     */
    private static void initGraph(int size) {
        visited = new boolean[size];
        map = new int[size][size];
    }

    /**
     * 关联两个节点
     * @param node1 节点1
     * @param node2 节点2
     */
    private static void buildGraph(int node1, int node2) {
        if (map == null) {
            return;
        }
        map[node1][node2] = map[node2][node1] = 1;
    }

    public static void main(String[] args) {
        Util.print("greph ==>");
        for (int i = 0; i < map.length; i++) {
            Util.print(map[i]);
        }
        dfs(0);
        Util.print("节点访问情况 ==> ");
        Util.print(visited);
    }

    /**
     * 深度优先搜索遍历
     * 1.对每一个节点进行搜索
     * 2.对节点a搜索到关联节点b后，通过递归操作对b节点进行搜索
     * 3.若b节点搜索不到关联节点时则执行完方法，跳回上一级搜索
     *
     * 核心思想：遍历图中的所有元素进行搜索，符合关联条件的则通过递归调用继续下一层搜索
     *
     * @param index 元素索引
     */
    private static void dfs(int index) {
        Util.print("====="+(index + 1) + "节点搜索开始 =====");
        visited[index] = true;
        for (int i = 0; i < map[index].length; i++) {
            if (map[index][i] == 1 && !visited[i]) {
                Util.print("搜索到未访问过的关联节点：" + (i + 1) + "，对应关系：" + (index + 1) + "-" + (i + 1));
                visited[i] = true;
                dfs(i);
            } else {
                Util.print((i + 1) + "不是有效节点，跳过");
            }
        }
        Util.print("====="+(index + 1) + "节点搜索结束 =====");
    }

}
