package com.base.knowledge;

import com.base.util.Util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索遍历图（使用邻接表）
 *
 * @author An Qi
 * @date 2020/8/5
 */
public class BFS {

    private static List<Integer>[] map;

    private static boolean[] visited;

    static{
        initGraph(7);
        buildGraph(0, 1);
        buildGraph(0, 2);
        buildGraph(0, 3);
        buildGraph(1, 0);
        buildGraph(1, 4);
        buildGraph(1, 5);
        buildGraph(2, 0);
        buildGraph(2, 6);
        buildGraph(3, 0);
        buildGraph(3, 6);
        buildGraph(4, 1);
        buildGraph(5, 1);
        buildGraph(6, 2);
        buildGraph(6, 3);
    }

    private static void initGraph(int size) {
        visited = new boolean[size];
        map = new List[size];
    }

    private static void buildGraph(int node1, int node2) {
        if (map[node1] == null) {
            map[node1] = new ArrayList<>();
        }
        map[node1].add(node2);
    }

    public static void main(String[] args) {
        bfs();
        Util.print("结束遍历，节点访问情况 ==>");
        Util.print(visited);
    }

    /**
     * 广度优先搜索
     * 1.使用queue记录需要访问的元素顺序
     * 2.向queue中添加第一个节点a，
     * 3.取出queue中元素，遍历a节点关联的所有未被访问的节点，并加入queue中
     * 3.依次操作queue中的每一个元素
     *
     * 核心思想：通过queue按照层级记录与根节点关联的元素顺序
     */
    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int a = queue.poll();
            Util.print("开始搜索" + (a + 1));
            for (int i = 0; i < map[a].size(); i++) {
                int node = map[a].get(i);
                if (!visited[node]) {
                    Util.print("搜索到关联节点：" + (node + 1) + "关联关系：" + (a + 1) + "-" + (node + 1));
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }


}
